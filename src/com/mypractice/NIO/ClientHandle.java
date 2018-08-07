package com.mypractice.NIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientHandle implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean started;

    public ClientHandle(String ip, int port){
        this.host = ip;
        this.port = port;
        try {
            // ����ѡ����
            selector = Selector.open();

            // �򿪼���ͨ��
            socketChannel = SocketChannel.open();

            socketChannel.configureBlocking(false);
            started = true;
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        started = false;
    }

    @Override
    public void run(){
        try {
            doConnect();
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        // ѭ������selector
        while (started){
            try {
                // �����Ƿ��ж�д������selectorÿ��һ�뱻����һ��
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e){
                        if (key != null){
                            key.cancel();
                            if (key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }


        // selector�رպ���Զ��ͷ�����������Դ
        if (selector != null){
            try {
                selector.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()){
                if (sc.finishConnect());
                else System.exit(1);
            }

            // ����Ϣ
            if (key.isReadable()){
                // ����ByteBuffer��������һ��1M�Ļ�����
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // ��ȡ�������������ض�ȡ�����ֽ���
                int readBytes = sc.read(buffer);
                if (readBytes > 0){
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String result = new String(bytes, "UTF-8");
                    System.out.println("�ͻ����յ���Ϣ��" + result);
                } else if (readBytes < 0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    private void doConnect() throws IOException {
        if (socketChannel.connect(new InetSocketAddress(host, port)));
        else socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void sendMsg(String msg) throws Exception {
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel, msg);
    }

    // �첽������Ϣ
    private void doWrite(SocketChannel channel, String request) throws IOException {
        // ����Ϣ����Ϊ�ֽ�����
        byte[] bytes = request.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        channel.write(writeBuffer);
    }
}

package com.mypractice.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ServerHandle implements Runnable {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started;

    public ServerHandle(int port){
        try {
            // ����ѡ����
            selector = Selector.open();
            // �򿪼�����
            serverSocketChannel = ServerSocketChannel.open();
            // ���Ϊtrue�����ͨ��������������ģʽ�����Ϊfalse����Ϊ������ģʽ
            serverSocketChannel.configureBlocking(false);
            // �󶨶˿�
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            // �����ͻ�����������
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // ����������
            started = true;
            System.out.println("���������������˿ںţ�" + port);
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
        // ѭ������selector
        while (started){
            try {
                // �����Ƿ��ж�д�¼�������selectorÿһ�뱻����һ��
                selector.select(1000);
                // ������ֻ�е�����һ��ע����¼�����ʱ�Ż����
                Set<SelectionKey> keys = selector.keys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey sk = null;
                while (it.hasNext()){
                    sk = it.next();
                    it.remove();
                    try {
                        handleInput(sk);
                    } catch (Exception e){
                        if (sk != null){
                            sk.cancel();
                            if (sk.channel() != null){
                                sk.channel().close();
                            }
                        }
                    }
                }
            } catch (Throwable t){
                t.printStackTrace();
            }
        }

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
            // �����½���������Ϣ
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

                // ͨ��ServerSocketChannel��accept����SocketChannelʵ��
                // ��ɸò�����ζ�����TCP�������֣�TCP������·��ʽ����
                SocketChannel sc = ssc.accept();

                // ����Ϊ������
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }

            // ����Ϣ
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();

                // ����ByteBuffer��������һ��1M������
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // ��ȡ�����������ض�ȡ���ֽ���
                int readBytes = sc.read(buffer);

                if (readBytes > 0){
                    // ����������ǰ��limit����Ϊposition=0�����ں����Ի������Ķ�ȡ����
                    buffer.flip();

                    //���ݻ������ɶ��ֽڴ�������
                    byte[] bytes = new byte[buffer.remaining()];

                    // ���������ɶ��ֽ����鸴�Ƶ��½���������
                    buffer.get(bytes);
                    String expression = new String(bytes, "UTF-8");
                    System.out.println("�������յ���Ϣ" + expression);


                    // ��������
                    String result = null;
                    try {
                        result = String.valueOf(new Random().nextInt(10));
                    } catch (Exception e){
                        result = "�������" + e.getMessage();
                    }

                    // ����Ӧ����Ϣ
                    doWrite(sc, result);
                } else if (readBytes < 0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    // �첽����Ӧ����Ϣ
    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        // ����Ϣ����Ϊ�ֽ�����
        byte[] bytes = response.getBytes();

        // ����������������ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

        // ���ֽ����鸴�Ƶ�������
        writeBuffer.put(bytes);

        writeBuffer.flip();

        // ���ͻ��������ֽ�����
        socketChannel.write(writeBuffer);

        // �˴�����д�������
    }

}

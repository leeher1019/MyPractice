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
            // 创建选择器
            selector = Selector.open();
            // 打开监听器
            serverSocketChannel = ServerSocketChannel.open();
            // 如果为true，则此通道将被置于阻塞模式；如果为false，则为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            // 监听客户端连接请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 服务器开启
            started = true;
            System.out.println("服务器已启动，端口号：" + port);
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
        // 循环遍历selector
        while (started){
            try {
                // 无论是否有读写事件发生，selector每一秒被唤醒一次
                selector.select(1000);
                // 阻塞，只有当至少一个注册的事件发生时才会继续
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
            // 处理新接入请求消息
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

                // 通过ServerSocketChannel的accept创建SocketChannel实例
                // 完成该操作意味着完成TCP三次握手，TCP物理链路正式建立
                SocketChannel sc = ssc.accept();

                // 设置为非阻塞
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }

            // 读消息
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();

                // 创建ByteBuffer，并开辟一个1M缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                // 读取请求流，返回读取的字节数
                int readBytes = sc.read(buffer);

                if (readBytes > 0){
                    // 将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    buffer.flip();

                    //根据缓冲区可读字节创建数组
                    byte[] bytes = new byte[buffer.remaining()];

                    // 将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String expression = new String(bytes, "UTF-8");
                    System.out.println("服务器收到消息" + expression);


                    // 处理数据
                    String result = null;
                    try {
                        result = String.valueOf(new Random().nextInt(10));
                    } catch (Exception e){
                        result = "计算错误" + e.getMessage();
                    }

                    // 发送应答消息
                    doWrite(sc, result);
                } else if (readBytes < 0){
                    key.cancel();
                    sc.close();
                }
            }
        }
    }

    // 异步发送应答消息
    private void doWrite(SocketChannel socketChannel, String response) throws IOException {
        // 将消息编码为字节数组
        byte[] bytes = response.getBytes();

        // 根据数据容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

        // 将字节数组复制到缓冲区
        writeBuffer.put(bytes);

        writeBuffer.flip();

        // 发送缓冲区的字节数组
        socketChannel.write(writeBuffer);

        // 此处不含写半包代码
    }

}

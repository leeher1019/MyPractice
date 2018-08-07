package com.mypractice.rpc;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * RPC客户端，这里发起调用请求
 * 模拟RPC框架调用过程
 *
 */
public class ObjectClientSerialize {
    public static void main(String[] args){
        try {
            // 第一步：
            // 使用Socket与指定IP、端口之主机连接
            Socket socket = new Socket("localhost", 7777);


            // 第二步：
            // 创建一个业务对象
            HelloService helloService = new HelloServiceImpl();

            // 该传输模型对象存储了客户端发起调用的业务对象的一些信息
            TransportModel transportModel = new TransportModel();

            // 设置客户端的调用对象
            transportModel.setObject(helloService);

            // 设置需要调用的方法
            transportModel.setMethodName("sayHello");

            // 获得业务对象的字节码信息
            Class clazz = helloService.getClass();

            // 在业务对象的字节码信息中获取"sayHello"，且方法输入参数为String的方法
            Method method = clazz.getMethod("sayHello", String.class);

            // 设置传输模型对象中的调用信息
            // 设置方法参数类型
            transportModel.setParamTypes(method.getParameterTypes());

            // 设置方法参数
            transportModel.setParams(new Object[]{"The first step of RPC"});


            // 第三步：
            // 把存储了业务对象信息的数据传输模型转为流，也就是序列化对象，方便在网络中传输
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(transportModel);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            // 获得一个socket的输出流，通过该流可以将数据传输到服务端
            OutputStream outputStream = socket.getOutputStream();

            // 往输出流中写入需要进行传输的序列化后的流信息
            outputStream.write(byteArray);
            outputStream.flush();


            // 第四步：
            // 因为socket建立的是长连接，所以可以获取到流数据传输到服务端返回的信息
            // 因为我们需要通过输入流，来获取服务端返回的流信息
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // 将得到的流数据读成Object对象，强转为我们的数据模型传输对象，最后得到服务端返回的结果
            TransportModel readObject = (TransportModel)objectInputStream.readObject();
            System.out.println("调用返回信息结果=" + readObject.getResult());
            socket.close();
            System.out.println("客户端调用结束。");
        } catch (IOException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

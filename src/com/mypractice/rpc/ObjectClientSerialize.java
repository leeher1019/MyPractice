package com.mypractice.rpc;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * RPC�ͻ��ˣ����﷢���������
 * ģ��RPC��ܵ��ù���
 *
 */
public class ObjectClientSerialize {
    public static void main(String[] args){
        try {
            // ��һ����
            // ʹ��Socket��ָ��IP���˿�֮��������
            Socket socket = new Socket("localhost", 7777);


            // �ڶ�����
            // ����һ��ҵ�����
            HelloService helloService = new HelloServiceImpl();

            // �ô���ģ�Ͷ���洢�˿ͻ��˷�����õ�ҵ������һЩ��Ϣ
            TransportModel transportModel = new TransportModel();

            // ���ÿͻ��˵ĵ��ö���
            transportModel.setObject(helloService);

            // ������Ҫ���õķ���
            transportModel.setMethodName("sayHello");

            // ���ҵ�������ֽ�����Ϣ
            Class clazz = helloService.getClass();

            // ��ҵ�������ֽ�����Ϣ�л�ȡ"sayHello"���ҷ����������ΪString�ķ���
            Method method = clazz.getMethod("sayHello", String.class);

            // ���ô���ģ�Ͷ����еĵ�����Ϣ
            // ���÷�����������
            transportModel.setParamTypes(method.getParameterTypes());

            // ���÷�������
            transportModel.setParams(new Object[]{"The first step of RPC"});


            // ��������
            // �Ѵ洢��ҵ�������Ϣ�����ݴ���ģ��תΪ����Ҳ�������л����󣬷����������д���
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(transportModel);
            objectOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            // ���һ��socket���������ͨ���������Խ����ݴ��䵽�����
            OutputStream outputStream = socket.getOutputStream();

            // ���������д����Ҫ���д�������л��������Ϣ
            outputStream.write(byteArray);
            outputStream.flush();


            // ���Ĳ���
            // ��Ϊsocket�������ǳ����ӣ����Կ��Ի�ȡ�������ݴ��䵽����˷��ص���Ϣ
            // ��Ϊ������Ҫͨ��������������ȡ����˷��ص�����Ϣ
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // ���õ��������ݶ���Object����ǿתΪ���ǵ�����ģ�ʹ���������õ�����˷��صĽ��
            TransportModel readObject = (TransportModel)objectInputStream.readObject();
            System.out.println("���÷�����Ϣ���=" + readObject.getResult());
            socket.close();
            System.out.println("�ͻ��˵��ý�����");
        } catch (IOException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

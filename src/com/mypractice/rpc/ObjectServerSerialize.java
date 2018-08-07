package com.mypractice.rpc;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * RPC�����
 *
 */

public class ObjectServerSerialize {
    public static void main(String[] args){
        try {
            // ��������ˣ�����7777�˿�
            ServerSocket serverSocket = new ServerSocket(7777);

            // �����󣬵ȴ��ͻ�������
            Socket socket = serverSocket.accept();

            // ��ȡ�ͻ��˵�����������������Ϣ����Object����
            // Ȼ��ǿתΪ���ǵ����ݴ���ģ�Ͷ�����Ϊ���ǿͻ���Ҳ���õĸö����䣬����ǿתû����
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            TransportModel transportModel = (TransportModel)objectInputStream.readObject();


            // ��Ϊ�ͻ����ڰ�����Ϣ������֮ǰ���Ѿ�����صĵ�����Ϣ��װ�����ǵ����ݴ���ģ�Ͷ�������
            // �����������ǿ���ֱ���õ���Щ�������Ϣ��Ȼ��ͨ�����䣬�Է������е���
            Object object = transportModel.getObject();
            String methodName = transportModel.getMethodName();
            Class<?>[] paramTypes = transportModel.getParamTypes();
            Object[] params = transportModel.getParams();

            // ͨ���������ͷ����������ͣ��õ�һ����������
            Method method = object.getClass().getMethod(methodName, paramTypes);

            // Ȼ��ͨ�������������ȥ����Ŀ�귽�������صľ����������ִ�к󷵻ص�����
            Object result = method.invoke(object, params);
            System.out.println("�ṩ�����ִ�з������ؽ����" + result);

            // ��÷���˵������
            OutputStream outputStream = socket.getOutputStream();

            // ����һ���ֽ�����������󣬰����ݴ���ģ�Ͷ������л�������������紫��
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // ����һ�����ݴ���ģ�Ͷ��󣬽�����˵ķ������ݴ����ͻ���
            TransportModel transportModel1 = new TransportModel();
            transportModel1.setResult(result);
            objectOutputStream.writeObject(transportModel1);

            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.flush();
            byteArrayOutputStream.close();
            outputStream.close();
            serverSocket.close();
            System.out.println("����˹ر�");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

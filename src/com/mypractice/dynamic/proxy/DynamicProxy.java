package com.mypractice.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object subject;

    public DynamicProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {

        // �ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���
        System.out.println("before rent toy");
        System.out.println("Method: " + method);

        // ��������������ʵ���󷽷�ʱ������Զ���ת��������������handler�����invoke���������е���
        method.invoke(subject, args);

        // �ڴ�����ʵ���������Ҳ�������һЩ�Լ��Ĳ���
        System.out.println("after rent toy");
        return null;
    }
}

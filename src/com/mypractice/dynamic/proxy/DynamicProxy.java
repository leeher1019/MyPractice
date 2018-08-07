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

        // 在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before rent toy");
        System.out.println("Method: " + method);

        // 当代理对象调用真实对象方法时，其会自动跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);

        // 在代理真实对象后，我们也可以添加一些自己的操作
        System.out.println("after rent toy");
        return null;
    }
}

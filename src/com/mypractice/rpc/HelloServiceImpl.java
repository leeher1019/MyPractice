package com.mypractice.rpc;

import java.io.Serializable;

/**
 * 业务方法实现类，远程调用需要实现序列化接口（Serializable）
 */
public class HelloServiceImpl implements HelloService, Serializable {

    private static final long serialVersionUID = 203100359025257718L;

    @Override
    public String sayHello(String str){
        System.out.println("执行方法体，输入参数=[" + str + "]");
        return str;
    }
}

package com.mypractice.rpc;

import java.io.Serializable;

/**
 * ҵ�񷽷�ʵ���࣬Զ�̵�����Ҫʵ�����л��ӿڣ�Serializable��
 */
public class HelloServiceImpl implements HelloService, Serializable {

    private static final long serialVersionUID = 203100359025257718L;

    @Override
    public String sayHello(String str){
        System.out.println("ִ�з����壬�������=[" + str + "]");
        return str;
    }
}

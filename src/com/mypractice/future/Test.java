package com.mypractice.future;

import javax.xml.crypto.Data;

public class Test {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

//        System.out.println("数据 = " + data.getResult());
    }
}

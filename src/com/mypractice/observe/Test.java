package com.mypractice.observe;

public class Test {
    public static void main(String[] args) {
        User a = new User("a");
        User b = new User("b");
        User c = new User("c");
        WechatServer wechatServer = new WechatServer();
        wechatServer.registerObserver(a);
        wechatServer.registerObserver(b);
        wechatServer.registerObserver(c);
        wechatServer.setInfo("test test");

        wechatServer.removeObserver(c);
        wechatServer.setInfo("hahahahaha");
    }

}

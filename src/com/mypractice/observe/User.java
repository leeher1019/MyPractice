package com.mypractice.observe;

public class User implements Observer {
    private String userName;
    private String message;

    public User(String userName){
        this.userName = userName;
    }

    @Override
    public void update(String message){
        this.message = message;
        this.read();
    }

    private void read(){
        System.out.println(userName + "收到消息推送" + message);
    }
}

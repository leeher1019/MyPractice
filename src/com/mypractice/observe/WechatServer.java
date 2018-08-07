package com.mypractice.observe;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observable {
    private List<Observer> list;
    private String message;

    public WechatServer(){
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o){
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        if (!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver(){
        for (int i = 0; i < list.size(); i++){
            Observer o = list.get(i);
            o.update(message);
        }
    }

    public void setInfo(String info){
        this.message = info;
        System.out.println("服务消息更新：" + info);
        this.notifyObserver();
    }
}

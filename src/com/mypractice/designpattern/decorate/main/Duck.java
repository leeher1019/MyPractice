package com.mypractice.designpattern.decorate.main;

public class Duck extends Food{

    public Duck(){
        desc = "duck";
    }

    @Override
    public String getDesc() {
        return desc;
    }
}

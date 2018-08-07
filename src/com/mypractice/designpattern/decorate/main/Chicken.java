package com.mypractice.designpattern.decorate.main;

public class Chicken extends Food {

    public Chicken(){
        desc = "chicken";
    }

    @Override
    public String getDesc(){
        return desc;
    }
}

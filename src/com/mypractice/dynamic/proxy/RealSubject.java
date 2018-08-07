package com.mypractice.dynamic.proxy;

public class RealSubject implements Subject {

    @Override
    public void rent(){
        System.out.println("I want to rent my toy");
    }

    @Override
    public void hello(String str){
        System.out.println("hello: " + str);
    }
}

package com.mypractice.reflection;

public class Bean {

    private int id = 1;
    private String name;

    public Bean(){

    }

    public Bean(int id, String name){
        this.id = id;
        this.name = name;
    }

    private void test(){
        System.out.println("this is a private method");
    }
}

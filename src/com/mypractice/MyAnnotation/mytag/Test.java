package com.mypractice.MyAnnotation.mytag;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args){
        Demo demo = new Demo();
        demoPorcess(demo);
        System.out.println(demo.getCar());
    }

    public static void demoPorcess(Demo demo){
        for (Field field : demo.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(MyTag.class)){
                MyTag myTag = field.getAnnotation(MyTag.class);
                demo.setCar(new Car(myTag.name(), myTag.size()));
            }
        }
    }
}

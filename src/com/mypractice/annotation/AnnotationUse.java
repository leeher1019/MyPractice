package com.mypractice.annotation;

import java.util.LinkedList;
import java.util.List;

@MyAnnotation(color = "red")
public class AnnotationUse {
    public static void main(String[] args){
        if (AnnotationUse.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = AnnotationUse.class.getAnnotation(MyAnnotation.class);
            System.out.println(myAnnotation.color());
        }
    }
}

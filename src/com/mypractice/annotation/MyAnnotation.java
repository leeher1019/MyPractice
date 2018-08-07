package com.mypractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Retentionע�����MyAnnotation����������
@Retention(RetentionPolicy.RUNTIME)
// Targetע�����MyAnnotation��������
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {

    /**
     * �����������
     */
    String color() default "blue";
}

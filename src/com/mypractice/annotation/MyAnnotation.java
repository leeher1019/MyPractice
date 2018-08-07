package com.mypractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Retention注解决定MyAnnotation的生命周期
@Retention(RetentionPolicy.RUNTIME)
// Target注解决定MyAnnotation的作用域
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {

    /**
     * 定义基本属性
     */
    String color() default "blue";
}

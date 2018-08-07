package com.mypractice.MyAnnotation.testtag;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestRunner {

    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Class clazz = SomeDaoImplTest.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            boolean hasMyTest = method.isAnnotationPresent(MyTest.class);
            if (hasMyTest){
                method.invoke(clazz.newInstance(), null);
            }
        }
    }
}

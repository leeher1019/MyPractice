package com.mypractice.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateTest {
    public static void main(String[] args) throws Exception {
        Class clazz = Bean.class;

        Bean bean = (Bean)clazz.newInstance();

        Method method = clazz.getDeclaredMethod("test", null);
        method.setAccessible(true);
        method.invoke(bean);

        Field id = clazz.getDeclaredField("id");
        id.setAccessible(true);
        int a = id.getInt(bean);
        System.out.println(a);


    }
}

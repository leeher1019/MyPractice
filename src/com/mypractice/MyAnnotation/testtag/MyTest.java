package com.mypractice.MyAnnotation.testtag;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface MyTest {
    long time() default -1;
}

package com.mypractice.MyAnnotation.testtag;

public class SomeDaoImplTest {

    private SomeDaoImpl someDao = new SomeDaoImpl();

    @MyTest
    public void testAdd(){
        someDao.save();
    }

    @MyTest
    public void testUpdate(){
        someDao.update();
    }
}

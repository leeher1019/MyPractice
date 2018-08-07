package com.mypractice.MyAnnotation.mytag;

public class Demo {

    @MyTag(name = "audi", size = 20)
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Annotation [car=" + car + "]";
    }
}

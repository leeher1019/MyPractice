package com.mypractice.MyAnnotation.mytag;

public class Car {

    private String name;
    private int size;

    public Car(String name, int size){
        this.size = size;
        this.name = name;
    }

    public Car(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}

package com.mypractice.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o){
        return this.age - o.age;
    }

    @Override
    public String toString(){
        return name + ":" + age;
    }

    public static void main(String[] args){
        Person james = new Person("James", 25);
        Person sabrina = new Person("Sabrina", 24);
        Person bingbing = new Person("BingBing", 36);
        List<Person> list = new ArrayList<>();
        list.add(james);
        list.add(sabrina);
        list.add(bingbing);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

//        int age = james.compareTo(new Person("Sabrina", 22));
//        System.out.println(age);
    }
}

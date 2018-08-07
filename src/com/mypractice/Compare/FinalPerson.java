package com.mypractice.Compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class FinalPerson {
    private int age;
    private String name;

    public FinalPerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name + ":" + age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args){
        FinalPerson first = new FinalPerson("a", 20);
        FinalPerson second = new FinalPerson("b", 24);
        FinalPerson third = new FinalPerson("c", 15);

        List<FinalPerson> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        System.out.println(list);

        Collections.sort(list, new Comparator<FinalPerson>(){
            @Override
            public int compare(FinalPerson o1, FinalPerson o2){
                if (o1 == null || o2 == null)
                    return 0;
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println(list);
    }
}

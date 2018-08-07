package com.mypractice.comparee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args){
        List<UserInfo> list = new ArrayList<>();
        list.add(new UserInfo(1, 21, "name1"));
        list.add(new UserInfo(2, 27, "name1"));
        list.add(new UserInfo(3, 15, "name1"));
        list.add(new UserInfo(5, 24, "name1"));
        list.add(new UserInfo(4, 24, "name1"));
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class UserInfo implements Comparable<UserInfo>{
    private int userId;
    private int age;
    private String name;

    public UserInfo(int userId, int age, String name) {
        this.userId = userId;
        this.age = age;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(UserInfo o){
        if (this.age - o.age == 0){
            return this.userId - o.userId;
        } else {
            return this.age - o.age;
        }
    }
}

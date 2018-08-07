package com.mypractice.comparee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args){
        List<UserInfo> list = new ArrayList<UserInfo>();
        list.add(new UserInfo(1,21,"name1"));
        list.add(new UserInfo(2,27,"name2"));
        list.add(new UserInfo(3,15,"name3"));
        list.add(new UserInfo(5,24,"name4"));
        list.add(new UserInfo(4,24,"name5"));
        MyComparator comparator = new MyComparator();
        Collections.sort(list, comparator);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class MyComparator implements Comparator<UserInfo> {

    @Override
    public int compare(UserInfo u1, UserInfo u2){
        if (u1.getAge() - u2.getAge() == 0){
            return u1.getUserId() - u2.getUserId();
        } else {
            return u1.getAge() - u2.getAge();
        }
    }
}

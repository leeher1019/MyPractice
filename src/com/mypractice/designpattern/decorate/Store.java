package com.mypractice.designpattern.decorate;

import com.mypractice.designpattern.decorate.condiment.RoastFood;
import com.mypractice.designpattern.decorate.condiment.SteamdFood;
import com.mypractice.designpattern.decorate.main.Chicken;
import com.mypractice.designpattern.decorate.main.Food;

public class Store {

    public static void main(String[] args){
        Food food = new Chicken();
        System.out.println(food.getDesc());

        Food dec1 = new SteamdFood(food);
        System.out.println(dec1.getDesc());

        Food dec2 = new RoastFood(dec1);
        System.out.println(dec2.getDesc());
    }
}

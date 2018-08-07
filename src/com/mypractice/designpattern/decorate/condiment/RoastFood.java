package com.mypractice.designpattern.decorate.condiment;

import com.mypractice.designpattern.decorate.main.Food;

public class RoastFood extends FoodDecoration {

    private Food food;

    public RoastFood(Food food){
        this.food = food;
    }

    @Override
    public String getDesc(){
        return getDecoration() + food.getDesc();
    }

    private String getDecoration(){
        return "roast ";
    }
}

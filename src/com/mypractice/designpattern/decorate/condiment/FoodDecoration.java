package com.mypractice.designpattern.decorate.condiment;

import com.mypractice.designpattern.decorate.main.Food;

public abstract class FoodDecoration extends Food {
    @Override
    public abstract String getDesc();
}

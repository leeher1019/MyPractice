package com.mypractice.test;

import java.math.BigDecimal;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class whatever {

    public static void main(String[] args){
        BigDecimal bigDecimal = new BigDecimal("46277242.52");
        double bigDecimalToDouble = bigDecimal.doubleValue();
        double sub = 1500000;
        BigDecimal big = bigDecimal.subtract(new BigDecimal(1500000));

        System.out.println(bigDecimalToDouble - sub);
        System.out.println(String.valueOf(bigDecimalToDouble - sub));
        System.out.println(big);
    }

}

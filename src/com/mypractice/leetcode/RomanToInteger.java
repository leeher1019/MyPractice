package com.mypractice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<String, Integer> initMap = new HashMap<>();

    static {
        initMap.put("I", 1);
        initMap.put("V", 5);
        initMap.put("X", 10);
        initMap.put("L", 50);
        initMap.put("C", 100);
        initMap.put("D", 500);
        initMap.put("M", 1000);
    }

    public static void main(String[] args){
        String roman = "MCMXCIV";
        RomanToInteger romanToInteger = new RomanToInteger();
        romanToInteger.romanToInt(roman);
    }

    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < roman.length; i++){
            if (i != roman.length - 1 && (
                    roman[i] == 'I' && (roman[i + 1] == 'X' || roman[i + 1] == 'V') ||
                    roman[i] == 'X' && (roman[i + 1] == 'C' || roman[i + 1] == 'L') ||
                    roman[i] == 'C' && (roman[i + 1] == 'M' || roman[i + 1] == 'D'))){
                sum -= initMap.get(String.valueOf(roman[i]));
            } else {
                sum += initMap.get(String.valueOf(roman[i]));
            }
        }
        return sum;
    }
}

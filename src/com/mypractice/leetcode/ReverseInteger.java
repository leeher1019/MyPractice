package com.mypractice.leetcode;

public class ReverseInteger {

    public static void main(String[] args){
        int input = 123;
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(input));
    }

    public int reverse(int x) {
        String xString = String.valueOf(x);
        char[] newString = new char[xString.length()];
        int startIndex = 0;
        if (xString.charAt(0) == '-'){
            newString[0] = '-';
            startIndex = 1;
        }

        for (int i = startIndex; i < xString.length(); i++){
            if (startIndex == 1) {
                newString[xString.length() - i] = xString.charAt(i);
            } else if (startIndex == 0){
                newString[xString.length() - i - 1] = xString.charAt(i);
            }
        }
        String output = String.valueOf(newString);
        if (Long.valueOf(output) > Math.pow(2, 31) - 1 || Long.valueOf(output) < -Math.pow(2, 31)){
            return 0;
        }
        return Integer.valueOf(String.valueOf(newString));
    }

    public int otherReverse(int x){
        int result = 0;
        while (x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}

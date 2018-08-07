package com.mypractice.leetcode;

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args){
        BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
        System.out.println(binaryNumberWithAlternatingBits.hasAlternatingBits(6));
        binaryNumberWithAlternatingBits.fastHasAlternatingBits(6);
    }

    public boolean hasAlternatingBits(int n) {
        boolean result = true;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < chars.length - 1; i++){
            if (chars[i] == chars[i + 1]){
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean fastHasAlternatingBits(int n){
        int prev = n & (1);
        n >>= 1;
        while(n > 0) {
            if(((n & 1) ^ prev) == 0) return false;
            prev = n & 1;
            n >>= 1;
        }
        return true;
    }
}

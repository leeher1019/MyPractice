package com.mypractice.leetcode;

public class PalindromeNumber {

    public static void main(String[] args){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        palindromeNumber.isPalindrome(-121);
        palindromeNumber.isPalindromeByInteger(121);
    }

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int input = x;
        StringBuilder compareString = new StringBuilder();
        compareString.append(x % 10);
        x /= 10;
        while (x > 0){
            compareString.append(x % 10);
            x /= 10;
        }
        return String.valueOf(input).equals(compareString.toString());

    }

    public boolean isPalindromeByInteger(int x){
        if (x < 0){
            return false;
        }
        int origin = x;
        int result = x % 10;
        x /= 10;
        while (x > 0){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == origin;
    }
}

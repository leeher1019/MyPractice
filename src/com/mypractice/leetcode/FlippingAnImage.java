package com.mypractice.leetcode;

public class FlippingAnImage {

    public static void main(String[] args){
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        flippingAnImage.flipAndInvertImage(A);
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++){
            flip(A[i]);
            invert(A[i]);
        }
        return A;
    }

    private int[] flip(int[] numbers){
        boolean isEven = numbers.length % 2 == 0;
        if (isEven){
            for (int i = 0; i < numbers.length / 2; i++){
                if (numbers[i] != numbers[numbers.length - i - 1]){
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers.length - i - 1];
                    numbers[numbers.length - i - 1] = temp;
                }
            }
        } else {
            for (int i = 0; i < numbers.length / 2; i++){
                if (numbers[i] != numbers[numbers.length - i - 1]){
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers.length - i - 1];
                    numbers[numbers.length - i - 1] = temp;
                }
            }
        }
        return numbers;
    }

    private int[] invert(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == 0){
                numbers[i] = 1;
            } else {
                numbers[i] = 0;
            }
        }
        return numbers;
    }
}

package com.mypractice.leetcode;

public class HammingDistance {

    public static void main(String[] args){
        HammingDistance hammingDistance = new HammingDistance();
        hammingDistance.hammingDistance(66,3);
    }

    public int hammingDistance(int x, int y) {
        long start = System.nanoTime();
        int result = x ^ y;
        StringBuilder strResult = new StringBuilder(Integer.toBinaryString(result));
        int count = 0;
        for (int i = 0; i < strResult.length(); i++){
            if (String.valueOf(strResult.charAt(i)).equals("1")){
                count++;
            }
        }
        System.out.println(System.nanoTime() - start + "Ãë");
        return count;
    }

    public int oneLineHammingDistance(int x, int y){
        return Integer.bitCount(x ^ y);
    }
}

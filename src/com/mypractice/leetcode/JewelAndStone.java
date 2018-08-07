package com.mypractice.leetcode;

import java.util.LinkedList;
import java.util.List;

public class JewelAndStone {
    public static void main(String[] args){
        JewelAndStone main = new JewelAndStone();
        int i = main.numJewelsInStones("aA", "aAAAAsss");
        int j = main.otherNumJewelsInStones("aA", "aAAAAsss");
        System.out.println("j:" + j);
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        List<String> sList = new LinkedList<>();
        for (int i = 0; i < S.length(); i++){
            sList.add(i, String.valueOf(S.charAt(i)));
        }

        for (int i = 0; i < J.length(); i++){
            int j = 0;
            while (j < sList.size()){
                if (String.valueOf(J.charAt(i)).equals(sList.get(j))){
                    count++;
                    sList.remove(j);
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    public int otherNumJewelsInStones(String J, String S){
        return S.replaceAll("[^" + J + "]", "").length();
    }
}

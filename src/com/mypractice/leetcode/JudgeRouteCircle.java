package com.mypractice.leetcode;

public class JudgeRouteCircle {
    public static void main(String[] args){
        String moves = "UD";
        JudgeRouteCircle judgeRouteCircle = new JudgeRouteCircle();
        judgeRouteCircle.judgeCircle(moves);
    }

    public boolean judgeCircle(String moves) {
        int upDown = 0;
        int leftRight = 0;

        for (int i = 0; i < moves.length(); i++){
            switch (moves.charAt(i)){
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
                case 'L':
                    leftRight--;
                    break;
                case 'R':
                    leftRight++;
                    break;
            }
        }
        return upDown == 0 && leftRight == 0;
    }

    public boolean otherJudgeCircle(String moves){
        int upDown = 0;
        int leftRight = 0;

        for (char c : moves.toCharArray()){
            switch (c){
                case 'U':
                    upDown++;
                    break;
                case 'D':
                    upDown--;
                    break;
                case 'L':
                    leftRight--;
                    break;
                case 'R':
                    leftRight++;
                    break;
            }
        }
        return upDown == 0 && leftRight == 0;
    }
}

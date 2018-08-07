package com.mypractice.spliterator;

public class Spliterator {
    public int countWordIteratively(String s){
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()){
            if (Character.isWhitespace(c)){
                lastSpace = true;
            } else {
                if (lastSpace){
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    private static String SENTENCE = " Nel   mezzo del cammin  di nostra  vita " +
                              "mi  ritrovai in una  selva oscura" +
                              " che la  dritta via era   smarrita ";
    public static void main(String[] args){
        Spliterator spliterator = new Spliterator();
        System.out.println("Found " + spliterator.countWordIteratively(SENTENCE));
    }
}

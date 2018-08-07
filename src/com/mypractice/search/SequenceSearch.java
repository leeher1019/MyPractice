package com.mypractice.search;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class SequenceSearch {

    public int search(int[] array, int key){
        for (int i = 0; i < array.length; i++){
            if (array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 4, 9, 3, 8, 7, 6, 0, 5};
        int key = 2;
        SequenceSearch sequenceSearch = new SequenceSearch();
        int result = sequenceSearch.search(array, key);
        System.out.println(String.format("key [%d] is located at [%d] index..", key, result));
    }
}

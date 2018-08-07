package com.mypractice.search;

public class BinarySearch {
    public int search(int[] array, int key, int start, int end){
        int mid = start + (end - start) / 2;
        if (start < end) {
            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                end = mid - 1;
                return search(array, key, start, end);
            } else if (key > array[mid]) {
                start = mid + 1;
                return search(array, key, start, end);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 2;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(array, key, 0, array.length - 1);
        System.out.println(String.format("key [%d] is located at [%d] index..", key, result));
    }
}

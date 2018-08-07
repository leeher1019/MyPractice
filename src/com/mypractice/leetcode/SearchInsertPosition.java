package com.mypractice.leetcode;

public class SearchInsertPosition {

    public static void main(String[] args){
        int[] input = {1, 3, 5, 6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(input, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (target > nums[i]){
                index = i;
                continue;
            } else if (target <= nums[i]){
                if (i == 0){
                    return index;
                }
                return ++index;
            }
        }
        if (index == nums.length - 1){
            index++;
        }
        return index;
    }
}

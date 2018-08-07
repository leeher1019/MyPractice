package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    O(nlogn)
 * @最优时间复杂度    O(nlogn)
 * @平均时间复杂度    O(nlogn)
 * @所需辅助空间      O(n)
 * @稳定性            稳定
 *
 */

public class MergeSort {
    public void merge(int[] array, int left, int mid, int right){        // 合并两个已排好序的数组A[left...mid]和A[mid + 1...right]
        int len = right - left + 1;
        int[] temp = new int[len];      // 辅助空间O(n)
        int index = 0;
        int i = left;                   // 前一数组起始元素
        int j = mid + 1;                // 后一数组起始元素
        while (i <= mid && j <= right){
            temp[index++] = array[i] <= array[j] ? array[i++] : array[j++]; // 带等号保证归并稳定性
        }
        while (i <= mid){
            temp[index++] = array[i++];
        }
        while (j <= right){
            temp[index++] = array[j++];
        }
        for (int k = 0; k < len; k++){
            array[left++] = temp[k];
        }
    }

    public void mergeSortRecursion(int[] array, int left, int right){   // 递归实现的归并排序（自顶向下）
        if (left == right){     // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRecursion(array, left, mid);
        mergeSortRecursion(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void mergeSortIteration(int[] array, int len){       // 非递归（迭代）实现的归并排序（自底向上）
        int left, mid, right;       //  子数组索引，前一个A[left...mid]和A[mid + 1...right]
        for (int i = 1; i < len; i *= 2){       // 子数组的大小i初始为1，每轮翻倍
            left = 0;
            while (left + i < len) {      // 后一个子数组存在(需要归并)
                mid = left + i - 1;
                right = mid + 1 < len ? mid + i : len - 1;      // 后一个子数组大小可能不够
                merge(array, left, mid, right);
                left = right + 1;
            }
        }
    }

    public static void main(String[] args){
        int[] a1 = {6, 5, 3, 1, 8, 7, 2, 4};  // 从小到大归并排序
        int[] a2 = {6, 5, 3, 1, 8, 7, 2, 4};
        int len1 = a1.length;
        int len2 = a2.length;
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortRecursion(a1, 0, len1 - 1);      // 递归实现
        mergeSort.mergeSortIteration(a2, len2);                       // 非递归实现
        System.out.println("递归实现排序结果：");
        Arrays.stream(a1).forEach(System.out::println);
        System.out.println("非递归实现排序结果：");
        Arrays.stream(a2).forEach(System.out::println);
    }
}
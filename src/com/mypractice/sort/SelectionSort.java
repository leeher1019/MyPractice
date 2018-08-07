package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    O(n^2)
 * @最优时间复杂度    O(n^2)
 * @平均时间复杂度    O(n^2)
 * @所需辅助空间      O(1)
 * @稳定性           不稳定
 *
 */

public class SelectionSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    public void sort(int[] array, int n){
        for (int i = 0; i < n; i++){            // i为已排序序列的末尾
            int min = i;
            for (int j = 0; j < n; j++){        // 未排序序列
                if (array[j] < array[min]){     // 找出未排序序列中的最小值
                    min = j;
                }
            }
            if (min != i){
                swap(array, min, i);            // 放到已排序序列的末尾，该操作很有可能把稳定性打乱，所以选择排序是不稳定的排序算法
            }
        }
    }

    public static void main(String[] args){
        int[] array = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
        int length = array.length;
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array, length);
        System.out.println("鸡尾酒排序结果：");
        Arrays.stream(array).forEach(System.out::println);
    }
}
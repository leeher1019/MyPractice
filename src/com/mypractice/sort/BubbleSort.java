package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    O(n^2)
 * @最优时间复杂度    如果能在内部循环第一次运行时，使用一个旗标表示有无需要交换的可能，可以把最优时间复杂度降到O(n)
 * @平均时间复杂度    O(n^2)
 * @所需辅助空间      O(1)
 * @稳定性           稳定
 *
 */
public class BubbleSort {
    private void swap(int array[], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(int array[], int n){
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (array[j] > array[j + 1]){       // 如果条件改为array[j] >= array[j + 1]，则变为不稳定的排序算法
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int length = array.length;
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array, length);
        System.out.println("冒泡排序结果：");
        Arrays.stream(array).forEach(System.out::println);
    }
}

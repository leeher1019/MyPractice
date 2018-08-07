package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    O(n^2)
 * @最优时间复杂度    如果序列在一开始已经大部分排序过的话，会接近O(n)
 * @平均时间复杂度    O(n^2)
 * @所需辅助空间      O(1)
 * @稳定性           稳定
 *
 */

public class CockTailSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    public void sort(int[] array, int n){
        int left = 0;           // 初始化边界
        int right = n - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]){
                    swap(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--){
                if (array[i] < array[i - 1]){
                    swap(array, i - 1, i);
                }
            }
            left++;
        }
    }

    public static void main(String[] args){
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int length = array.length;
        CockTailSort cockTailSort = new CockTailSort();
        cockTailSort.sort(array, length);
        System.out.println("鸡尾酒排序结果：");
        Arrays.stream(array).forEach(System.out::println);
    }
}

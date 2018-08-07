package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
 * @最优时间复杂度    O(n)
 * @平均时间复杂度    根据步长序列的不同而不同。
 * @所需辅助空间      O(1)
 * @稳定性            不稳定
 *
 */

public class ShellSort {
    public void sort(int[] array, int n){
        int h = 0;
        while (h <= n){
            h = h * 3 + 1;
        }
        while (h >= 1){                                  // 生成初始量
            for (int i = h; i < n; i++){
                int j = i - h;
                int get = array[i];
                while (j >= 0 && array[j] > get){
                    array[j + h] = array[j];
                    j = j - h;
                }
                array[j + h] = get;
            }
            h = (h - 1) / 3;                            // 递减增量
        }
    }

    public static void main(String[] args){
        int[] array = {5, 2, 9, 4, 7, 6, 1, 3, 8};  // 从小到大希尔排序
        int length = array.length;
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array, length);
        System.out.println("希尔排序结果：");
        Arrays.stream(array).forEach(System.out::println);
    }
}

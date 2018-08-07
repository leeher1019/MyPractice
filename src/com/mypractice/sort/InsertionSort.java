package com.mypractice.sort;

import java.util.Arrays;

/**
 * @分类              内部比较排序
 * @数据结构          数组
 * @最差时间复杂度    最坏的情况为降序排列，此时时间复杂度为O(n^2)
 * @最优时间复杂度    最好的情况为升序排列，此时时间复杂度为O(n)
 * @平均时间复杂度    O(n^2)
 * @所需辅助空间      O(1)
 * @稳定性           稳定
 *
 */

public class InsertionSort {
    public void sort(int[] array, int n){
        for (int i = 0; i < n; i++){                // 类似抓扑克牌排序
            int get = array[i];                     // 右手抓到一张牌
            int j = i - 1;                          // 拿在左手的牌总是排序好的
            while (j >= 0 && array[j] > get){       // 将抓到的牌与手牌从右向左进行比较
                array[j + 1] = array[j];            // 如果该手牌比抓到的牌大，就将其向右移
                j--;
            }
            array[j + 1] = get;                     // 直到该手牌比抓到的牌小(或二者相等)，将抓到的牌插入到该手牌右边(相等元素的相对次序未变，所以插入排序是稳定的)
        }
    }

    public static void main(String[] args){
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int length = array.length;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array, length);
        System.out.println("鸡尾酒排序结果：");
        Arrays.stream(array).forEach(System.out::println);
    }
}
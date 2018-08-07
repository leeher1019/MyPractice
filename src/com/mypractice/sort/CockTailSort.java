package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(n^2)
 * @����ʱ�临�Ӷ�    ���������һ��ʼ�Ѿ��󲿷�������Ļ�����ӽ�O(n)
 * @ƽ��ʱ�临�Ӷ�    O(n^2)
 * @���踨���ռ�      O(1)
 * @�ȶ���           �ȶ�
 *
 */

public class CockTailSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    public void sort(int[] array, int n){
        int left = 0;           // ��ʼ���߽�
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
        System.out.println("��β����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}

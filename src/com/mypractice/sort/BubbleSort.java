package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(n^2)
 * @����ʱ�临�Ӷ�    ��������ڲ�ѭ����һ������ʱ��ʹ��һ������ʾ������Ҫ�����Ŀ��ܣ����԰�����ʱ�临�ӶȽ���O(n)
 * @ƽ��ʱ�临�Ӷ�    O(n^2)
 * @���踨���ռ�      O(1)
 * @�ȶ���           �ȶ�
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
                if (array[j] > array[j + 1]){       // ���������Ϊarray[j] >= array[j + 1]�����Ϊ���ȶ��������㷨
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
        System.out.println("ð����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}

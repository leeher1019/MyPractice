package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(n^2)
 * @����ʱ�临�Ӷ�    O(n^2)
 * @ƽ��ʱ�临�Ӷ�    O(n^2)
 * @���踨���ռ�      O(1)
 * @�ȶ���           ���ȶ�
 *
 */

public class SelectionSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    public void sort(int[] array, int n){
        for (int i = 0; i < n; i++){            // iΪ���������е�ĩβ
            int min = i;
            for (int j = 0; j < n; j++){        // δ��������
                if (array[j] < array[min]){     // �ҳ�δ���������е���Сֵ
                    min = j;
                }
            }
            if (min != i){
                swap(array, min, i);            // �ŵ����������е�ĩβ���ò������п��ܰ��ȶ��Դ��ң�����ѡ�������ǲ��ȶ��������㷨
            }
        }
    }

    public static void main(String[] args){
        int[] array = {8, 5, 2, 6, 9, 3, 1, 4, 0, 7};
        int length = array.length;
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array, length);
        System.out.println("��β����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}
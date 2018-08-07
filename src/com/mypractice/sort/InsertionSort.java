package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    ������Ϊ�������У���ʱʱ�临�Ӷ�ΪO(n^2)
 * @����ʱ�临�Ӷ�    ��õ����Ϊ�������У���ʱʱ�临�Ӷ�ΪO(n)
 * @ƽ��ʱ�临�Ӷ�    O(n^2)
 * @���踨���ռ�      O(1)
 * @�ȶ���           �ȶ�
 *
 */

public class InsertionSort {
    public void sort(int[] array, int n){
        for (int i = 0; i < n; i++){                // ����ץ�˿�������
            int get = array[i];                     // ����ץ��һ����
            int j = i - 1;                          // �������ֵ�����������õ�
            while (j >= 0 && array[j] > get){       // ��ץ�����������ƴ���������бȽ�
                array[j + 1] = array[j];            // ��������Ʊ�ץ�����ƴ󣬾ͽ���������
                j--;
            }
            array[j + 1] = get;                     // ֱ�������Ʊ�ץ������С(��������)����ץ�����Ʋ��뵽�������ұ�(���Ԫ�ص���Դ���δ�䣬���Բ����������ȶ���)
        }
    }

    public static void main(String[] args){
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int length = array.length;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array, length);
        System.out.println("��β����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}
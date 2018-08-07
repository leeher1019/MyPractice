package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    ÿ��ѡȡ�Ļ�׼������󣨻���С����Ԫ�أ�����ÿ��ֻ���ֳ���һ����������Ҫ����n-1�λ��ֲ��ܽ����ݹ飬ʱ�临�Ӷ�ΪO(n^2)
 * @����ʱ�临�Ӷ�    ÿ��ѡȡ�Ļ�׼������λ��������ÿ�ζ����ȵĻ��ֳ�����������ֻ��Ҫlogn�λ��־��ܽ����ݹ飬ʱ�临�Ӷ�ΪO(nlogn)
 * @ƽ��ʱ�临�Ӷ�    O(nlogn)
 * @���踨���ռ�      ��Ҫ�ǵݹ���ɵ�ջ�ռ��ʹ��(��������left��right�Ⱦֲ�����)��ȡ���ڵݹ�������ȣ�һ��ΪO(logn)�����ΪO(n)
 * @�ȶ���            ���ȶ�
 *
 */

public class QuickSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    private int partition(int[] array, int left, int right){     // ���ֺ���
        int pivot = array[right];       // ����ÿ�ζ�ѡ�����һ��Ԫ����Ϊ��׼
        int tail = left - 1;            // tailΪС�ڻ�׼�����������һ��Ԫ�ص�����
        for (int i = left; i < right; i++){     // ������׼���������Ԫ��
            if (array[i] <= pivot){
                swap(array, ++tail, i);
            }
        }
        swap(array, tail + 1, right);   // ���ѻ�׼�ŵ�ǰһ��������ĺ�ߣ�ʣ�µ���������Ǵ��ڻ�׼��������
                                              // �ò������п��ܰѺ���Ԫ�ص��ȶ��Դ��ң����Կ��������ǲ��ȶ��������㷨
        return tail + 1;            // ���ػ�׼������
    }

    public void sort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int pivot_index = partition(array, left, right);    // ��׼������
        sort(array, left, pivot_index - 1);
        sort(array, pivot_index + 1, right);
    }

    public static void main(String[] args){
        int[] array = {5, 2, 9, 4, 7, 6, 1, 3, 8};  // ��С��������
        int len = array.length;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, len - 1);
        System.out.println("������������");
        Arrays.stream(array).forEach(System.out::println);
    }
}
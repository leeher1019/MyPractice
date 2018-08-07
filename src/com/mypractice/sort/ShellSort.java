package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    ���ݲ������еĲ�ͬ����ͬ����֪��õ�ΪO(n(logn)^2)
 * @����ʱ�临�Ӷ�    O(n)
 * @ƽ��ʱ�临�Ӷ�    ���ݲ������еĲ�ͬ����ͬ��
 * @���踨���ռ�      O(1)
 * @�ȶ���            ���ȶ�
 *
 */

public class ShellSort {
    public void sort(int[] array, int n){
        int h = 0;
        while (h <= n){
            h = h * 3 + 1;
        }
        while (h >= 1){                                  // ���ɳ�ʼ��
            for (int i = h; i < n; i++){
                int j = i - h;
                int get = array[i];
                while (j >= 0 && array[j] > get){
                    array[j + h] = array[j];
                    j = j - h;
                }
                array[j + h] = get;
            }
            h = (h - 1) / 3;                            // �ݼ�����
        }
    }

    public static void main(String[] args){
        int[] array = {5, 2, 9, 4, 7, 6, 1, 3, 8};  // ��С����ϣ������
        int length = array.length;
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array, length);
        System.out.println("ϣ����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}

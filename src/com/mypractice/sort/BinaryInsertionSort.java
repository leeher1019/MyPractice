package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(n^2)
 * @����ʱ�临�Ӷ�    O(nlogn)
 * @ƽ��ʱ�临�Ӷ�    O(n^2)
 * @���踨���ռ�      O(1)
 * @�ȶ���            �ȶ�
 *
 */

public class BinaryInsertionSort {
    public void sort(int[] array, int n){
        for (int i = 1; i < n; i++){
            int get = array[i];                     // ����ץ��һ���˿���
            int left = 0;                           // ���������ϵ�����������õģ����Կ����ö��ַ�
            int right = i - 1;                      // �������ұ߽���г�ʼ��
            while(left <= right){                   // ���ö��ַ���λ���Ƶ�λ��
                int mid = (left + right) / 2;
                if (array[mid] > get){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int j = i - 1; j >= left; j--){    // ������������λ���ұߵ������������ƶ�һ����λ
                array[j + 1] = array[j];
            }
            array[left] = get;                      // ��ץ�����Ʋ�������
        }
    }

    public static void main(String[] args){
        int[] array = {5, 2, 9, 4, 7, 6, 1, 3, 8};
        int length = array.length;
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        binaryInsertionSort.sort(array, length);
        System.out.println("���ֲ�����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}
package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(nlogn)
 * @����ʱ�临�Ӷ�    O(nlogn)
 * @ƽ��ʱ�临�Ӷ�    O(nlogn)
 * @���踨���ռ�      O(n)
 * @�ȶ���            �ȶ�
 *
 */

public class MergeSort {
    public void merge(int[] array, int left, int mid, int right){        // �ϲ��������ź��������A[left...mid]��A[mid + 1...right]
        int len = right - left + 1;
        int[] temp = new int[len];      // �����ռ�O(n)
        int index = 0;
        int i = left;                   // ǰһ������ʼԪ��
        int j = mid + 1;                // ��һ������ʼԪ��
        while (i <= mid && j <= right){
            temp[index++] = array[i] <= array[j] ? array[i++] : array[j++]; // ���Ⱥű�֤�鲢�ȶ���
        }
        while (i <= mid){
            temp[index++] = array[i++];
        }
        while (j <= right){
            temp[index++] = array[j++];
        }
        for (int k = 0; k < len; k++){
            array[left++] = temp[k];
        }
    }

    public void mergeSortRecursion(int[] array, int left, int right){   // �ݹ�ʵ�ֵĹ鲢�����Զ����£�
        if (left == right){     // ������������г���Ϊ1ʱ���ݹ鿪ʼ���ݣ�����merge����
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRecursion(array, left, mid);
        mergeSortRecursion(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public void mergeSortIteration(int[] array, int len){       // �ǵݹ飨������ʵ�ֵĹ鲢�����Ե����ϣ�
        int left, mid, right;       //  ������������ǰһ��A[left...mid]��A[mid + 1...right]
        for (int i = 1; i < len; i *= 2){       // ������Ĵ�Сi��ʼΪ1��ÿ�ַ���
            left = 0;
            while (left + i < len) {      // ��һ�����������(��Ҫ�鲢)
                mid = left + i - 1;
                right = mid + 1 < len ? mid + i : len - 1;      // ��һ���������С���ܲ���
                merge(array, left, mid, right);
                left = right + 1;
            }
        }
    }

    public static void main(String[] args){
        int[] a1 = {6, 5, 3, 1, 8, 7, 2, 4};  // ��С����鲢����
        int[] a2 = {6, 5, 3, 1, 8, 7, 2, 4};
        int len1 = a1.length;
        int len2 = a2.length;
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSortRecursion(a1, 0, len1 - 1);      // �ݹ�ʵ��
        mergeSort.mergeSortIteration(a2, len2);                       // �ǵݹ�ʵ��
        System.out.println("�ݹ�ʵ����������");
        Arrays.stream(a1).forEach(System.out::println);
        System.out.println("�ǵݹ�ʵ����������");
        Arrays.stream(a2).forEach(System.out::println);
    }
}
package com.mypractice.sort;

import java.util.Arrays;

/**
 * @����              �ڲ��Ƚ�����
 * @���ݽṹ          ����
 * @���ʱ�临�Ӷ�    O(nlogn)
 * @����ʱ�临�Ӷ�    O(nlogn)
 * @ƽ��ʱ�临�Ӷ�    O(nlogn)
 * @���踨���ռ�      O(1)
 * @�ȶ���            ���ȶ�
 *
 */

public class HeapSort {
    private void swap(int[] array, int front, int back){
        int temp = array[front];
        array[front] = array[back];
        array[back] = temp;
    }

    private void heapify(int[] array, int i, int size){     // ��A[i]���½��жѵ���
        int left_child = 2 * i + 1;     // ��������
        int right_child = 2 * i + 2;    // �Һ�������
        int max = i;                    // ѡ����ǰ����������Һ�������֮�е����ֵ
        if (left_child < size && array[left_child] > array[max]){
            max = left_child;
        }
        if (right_child < size && array[right_child] > array[max]){
            max = right_child;
        }
        if (max != i){
            swap(array, i, max);        // �ѵ�ǰ�����������ֱ�ӣ��ӽڵ���н���
            heapify(array, max, size);  // �ݹ���ã������ӵ�ǰ������½��жѵ���
        }
    }

    private int buildHeap(int[] array, int n){          // ���ѣ�ʱ�临�Ӷ�O(n)
        int heap_size = n;
        for (int i = heap_size / 2 - 1; i >= 0; i--){   // ��ÿһ����Ҷ��㿪ʼ���½��жѵ���
            heapify(array, i, heap_size);
        }
        return heap_size;
    }

    public void sort(int[] array, int n){
        int heap_size = buildHeap(array, n);        // ����һ������
        while (heap_size > 1){                  // �ѣ���������Ԫ�ظ�������1��δ�������
            // ���Ѷ�Ԫ����ѵ����һ��Ԫ�ػ��������Ӷ���ȥ�����һ��Ԫ��
            // �˴������������п��ܰѺ���Ԫ�ص��ȶ��Դ��ң����Զ������ǲ��ȶ��������㷨
            swap(array, 0, --heap_size);
            heapify(array, 0, heap_size);       // ���µĶѶ�Ԫ�ؿ�ʼ���½��жѵ�����ʱ�临�Ӷ�O(logn)
        }
    }

    public static void main(String[] args){
        int[] array = {5, 2, 9, 4, 7, 6, 1, 3, 8};  // ��С���������
        int len = array.length;
        HeapSort heapSort = new HeapSort();
        heapSort.sort(array, len);
        System.out.println("����������");
        Arrays.stream(array).forEach(System.out::println);
    }
}
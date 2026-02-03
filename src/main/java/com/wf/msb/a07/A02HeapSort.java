package com.wf.msb.a07;

import java.util.Arrays;

public class A02HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{7, 8, 2, 1, 4, 9, 6, 3, 5};

        heapSort1(array);

    }

    public static void heapSort1(int[] array) {
        // 此时变成大根堆了
        /*for (int j = 0; j < array.length ; j++) {
            heapInsert(j, array);
        }*/

        for (int j = 0; j < array.length ; j++) {
            heapInsert(j, array);
        }

        swap(array, 0, array.length - 1);
        // 交换之后，可以看作是大根堆弹出去数据，然后将最后一个位置上的值，转换到了第一位值，然后执行heapify处理。
        int heapsize = array.length-1;
        while (heapsize>0){
            heapify(0,heapsize,array);
            swap(array,0,heapsize-1);
            heapsize--;
        }


        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length - i; j++) {
                heapInsert(j, array);
            }

            swap(array, 0, array.length - 1 - i);
        }

        System.out.println(Arrays.toString(array));
    }

    public static void heapInsert(int index, int[] array) {
        while (index > 0) {
            if (array[index] > array[((index - 1) / 2)]) {
                swap(array, index, (index - 1) / 2);
            }
            index = ((index - 1) / 2);
        }

       /* while (array[index] > array[((index - 1) / 2)]) {
            swap(array, index, (index - 1) / 2);
            index = ((index - 1) / 2);
        }*/
    }

    public static void heapify(int index, int heapSize, int[] array) {
        int leftChildren = index * 2 + 1;

        while (leftChildren < heapSize) {

            int largest = leftChildren + 1 < heapSize && array[leftChildren] < array[leftChildren + 1] ? leftChildren + 1 : leftChildren;

            largest = array[index] < array[largest] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(array, index, largest);
            index = largest;

            leftChildren = index * 2 + 1;

        }
    }


    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}

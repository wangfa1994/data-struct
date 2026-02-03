package com.wf.msb.a02;

import java.util.Arrays;

/*
* 选择排序
*  循环选择一个最小值，进行分别放入到第一个，第二个，第N个位置
*  0 ~ N-1  找到最小值，在哪，放到0位置上
*  1 ~ n-1  找到最小值，在哪，放到1 位置上
*  2 ~ n-1  找到最小值，在哪，放到2 位置上
*  .......
* */
public class A01SelectSort {


    /*public static void main(String[] args) {
            int[] array = new int[]{9,7,5,6,4,2,3,1,8};
            selectSort(array);
            System.out.println(Arrays.toString(array));
    }*/

    public static void selectSort(int [] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1;j<array.length;j++){ // 循环选择一个最小的值，交换到第i个位置
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }


    }

    public static void swap(int[] array ,int i ,int j){
        int temp  = array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    // 对数器进行对比
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // [-? , +?]
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

       /* int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);*/
    }

}

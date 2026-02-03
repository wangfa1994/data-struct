package com.wf.msb.a05;

import java.util.Arrays;

/**
 * 归并排序
 * 利用递归，将一个数组无限分小，进行排序。然后再进行合并
 */
public class A01MergeSort {

    public static void main(String[] args) {




        int[] array = new int[]{1,2,3,6,5,4,7,8,9};

        mergeSortWithLoop(array);

        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));


    }

    // 数组 array 从 L 到 R 上有序  递归版本
    public static void mergeSort(int[] array ,int L ,int R){
        if(L==R){
            return ;
        }
        int mid = L+((R-L)>>1);
       mergeSort(array, L, mid);
       mergeSort(array, mid + 1, R);

       combine(array,L,mid,R);
    }

    // master公式求时间复杂度
    public static void combine(int[]array,int L ,int M,int R ){
        int[] help = new int[R-L+1]; // 准备一个辅助数组
        int i = 0;

        int pointL = L;
        int pointR =M+1;
        while (pointL <= M && pointR <=R){
                help[i++] = array[pointL] <= array[pointR]?array[pointL++]:array[pointR++];
        }

        while (pointL<=M){
            help[i++] = array[pointL++];
        }

        while (pointR <=R){
            help[i++]=array[pointR++];
        }


        for (int j = 0; j < help.length; j++) {
            array[L+j] = help[j];
        }
        
    }




    // 设定步长进行循环，步长扩*2，使用步长，用来替换递归，数据量不够，也能合并，局部已经有序，不够就不够了，没关系。
    // 非递归方法实现
    public static void mergeSortWithLoop(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 步长
        int mergeSize = 1;
        while (mergeSize < N) { // log N
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) { // L 的位置开始跳，
                int M = L + mergeSize - 1; // 得到此次的中间位置
                if(M>=N){
                    break; // 如果中间值都超过了数组长度，不用再进行合并了。左组不够了
                }
                // 计算右组,M+步长，可能不够，够的话M+步长，不够的话N-1
                int R =  Math.min(M + mergeSize, N - 1);
                sorted(arr, L, M, R);
                L = R + 1;  //跳转到下一个需要排序的位置,开始本次步长的下一个循环
            }
            // 防止溢出 ,判断下一次的步长，不能超过最大值，滚成负数了，N的长度无限接近于int最大值是，等于的话，会少算一轮， 假设超过10越界，N=9
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;  //一次结束后，步长*2
        }
    }

    private static void sorted(int[] array, int L, int mid,int R) {

        int[] help = new int[R-L+1];


        int p1 = L;
        int p2 =mid+1;
        int i = 0;
        while (p1<=mid && p2 <=R){
            help[i++] = array[p1]<=array[p2]?array[p1++]:array[p2++];
        }

        while (p1<=mid){
            help[i++] = array[p1++];
        }

        while (p2<=R){
            help[i++]=array[p2++];
        }

        for (int i1 = 0; i1 < help.length; i1++) {
            array[L+i1] = help[i1];
        }

    }


}

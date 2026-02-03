package com.wf.msb.a06;

import java.util.Arrays;

public class A04QuickSort {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,5,3,7,9,6};

        quickSort1(array,0,array.length-1);

        System.out.println(Arrays.toString(array));

        array = new int[]{1,2,5,3,7,9,6};
        quickSortWithBook(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort1(int[] array,int L ,int R){
        if(L>=R) return;;

        int mid  = heLan(array,L,R);
        quickSort1(array,L,mid-1);
        quickSort1(array,mid+1,R);

    }

    public static int heLan(int[] array,int L ,int R){
        int minIndex=L-1;
        int cur = L;
        int value = array[R];

        while (cur< R){
            if(array[cur]<value){
                swap(array,minIndex+1,cur);
                minIndex++;
            }
            cur++;
        }
        swap(array,minIndex+1,R);
        return ++minIndex;
    }


    private static void swap(int[] array, int v1,int v2){
        int temp = array[v1];
        array[v1]=array[v2];
        array[v2]=temp;
    }

    public static void quickSortWithBook(int[] array,int L ,int R){
        if(L>=R) return;

        int mid  = processor(array,L,R);
        quickSortWithBook(array,L,mid-1);
        quickSortWithBook(array,mid+1,R);
    }


    public static int processor(int[] array,int L ,int R){

        // int checkValue = array[L]; // 为什么不能用最后一个，要取第一个？
        int checkValue = array[R];
        while (L<R){
            while (L<R && checkValue <= array[R]){
                R--;
            }
            swap(array,L,R);
            while (L<R && checkValue >= array[L]){
                L++;
            }
            swap(array,L,R);
        }
        return L;
    }
}

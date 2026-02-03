package com.wf.msb.a07;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 已知一个几乎有序的数组，几乎有序是指如果把数组排好顺序的话，每个元素移动的距离一定不超过K，并且K相对于数组长度来说是比较小的。
 * 请选择一个合适的排序策略，对这个数组进行排序。
 * 【3,4,1,2,5】 K =2 ====》【1,2,3,4,5】，小规模有序
 * 这个可以利用给定的规模进行放入小根堆中进行去实现。
 *
 */
public class A03HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,4,1,2,5};
        sort(array,2);
        System.out.println(Arrays.toString(array));

        array = new int[]{5,3,4,6,1,2,9,7,8};

        sort(array,5);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] array,int k){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k+1);

        int reset = 0;
        for (int i = 0; i <= array.length-1; i++) {

            if(i<=k){
                priorityQueue.add(array[i]);
            }else{
                array[reset++] = priorityQueue.poll();
                priorityQueue.add(array[i]);
            }
        }
        for (int i = 0; i <= k; i++) {
            array[reset++] = priorityQueue.poll();
        }


    }
}

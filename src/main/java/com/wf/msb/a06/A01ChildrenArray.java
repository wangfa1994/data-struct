package com.wf.msb.a06;

import java.util.Arrays;

// 计算子数组 等差数列
public class A01ChildrenArray {


    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4};

        array = new int[]{-3,1,2,4,0,-1,5};
        preSum(array);
        childrenArray(array);

    }

    private static void childrenArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j =i;j< array.length;j++){
                System.out.println(i+"---"+j+"位置上的子数组");
                for (int k = i ;k<=j;k++){
                    System.out.printf(array[k]+"");
                }
                System.out.println("");
            }
        }

    }

    private static void preSum(int[] array) {
        int[] preSum = new int[array.length];

        preSum[0]=array[0];
        for (int i = 1; i < array.length; i++) {
            preSum[i] = preSum[i-1]+array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(preSum));
    }


}

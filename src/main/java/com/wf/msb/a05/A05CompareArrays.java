package com.wf.msb.a05;


// 6. 两个有序数组，怎么求解，第二个数组乘以2比第一个数组小于的值个数

/*
* 【1,2,5,6,7,9】 和 [1,1,2,3,4]
*  使用一个指针进行第二个数组的移动，这个指针在第二个数组上不回退，因为都是有序的，所以，只要遇到一个不小于的，前面的肯定也是这样的。
*
* */
public class A05CompareArrays {

    public static void main(String[] args) {

        int[] array1 = new int[]{1,2,5,6,7,9};
        int[] array2 = new int[]{1,1,2,3,4};

        int i = sortNum(array1, array2);
        System.out.println(i);


    }

    public static int sortNum(int[] array1, int[] array2) {
        int count = 0;

        int windowR = 0;
        for (int i = 0; i < array1.length; i++) {
            int compareValue = array1[i];
            while (compareValue > (array2[windowR]<<2)){
                windowR++;
            }
            count = count+(windowR);

        }
        return count;
    }
}

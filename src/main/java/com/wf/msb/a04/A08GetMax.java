package com.wf.msb.a04;

/**
 *  利用递归，得到一个数组的最大值。
 *  递归分解小问题
 *
 */
public class A08GetMax {

    public static void main(String[] args) {
        int[] array = new int[]{1,5,9,8,7,4,6,2,3,7,5};
        System.out.println(maxCount(array,0,array.length-1));
    }

    public static int maxCount(int[] array,int left ,int right){
        if(left == right){
            return array[right]; // base case
        }
        int mid  = left+((right-left)>>2);
        int resultLeft = maxCount(array,left,mid);
        int resultRight = maxCount(array,mid+1,right);
        return Math.max(resultLeft, resultRight);
    }
}

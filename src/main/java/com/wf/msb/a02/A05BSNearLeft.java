package com.wf.msb.a02;

/**
 * 二分法使用场景一： 二分查找大于等于某个值的最左边的位置
 *
 *  1,2,2,3,3,3, 4, 5, 6   大于等于3最左边的    小于等于3最左边的值
 *
 */
public class A05BSNearLeft {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,3,3,3, 4, 5, 6};
        int i = bsCheck(array, 3);
        System.out.println(i);
    }

    public static int bsCheck(int[] array , int checkValue){

        int L =0;
        int R = array.length;
        int index = -1;
        while (L<=R){
            int mid = (L+R)/2;
            if(array[mid]>checkValue){
                R = mid-1;
            }else if(array[mid]<checkValue){
                L=mid+1;
            }else {
                index = mid;
                R = mid-1;
            }
        }
        return index;
    }


}

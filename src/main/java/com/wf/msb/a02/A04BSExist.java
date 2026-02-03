package com.wf.msb.a02;

/* 二分法使用场景一： 二分查找确定的值
*
* */
public class A04BSExist {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = bsCheck(array, 9);
        System.out.println(i);
        System.out.println(exist(array, 9));

    }


    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        // L..R
        while (L < R) { // L..R 至少两个数的时候
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }


    public static int bsCheck(int[] array , int checkValue){

        int L =0;
        int R = array.length;
        while (L<R){
            int mid = (L+R)/2;
            if(array[mid]>checkValue){
                R = mid-1;
            }else if(array[mid]<checkValue){
                L=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

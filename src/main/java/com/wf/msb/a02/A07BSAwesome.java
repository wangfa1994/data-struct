package com.wf.msb.a02;


/*
*  二分法使用场景一： 局部最小值
*
* */
public class A07BSAwesome {

    public static void main(String[] args) {

        int[] array = new int[]{3,2,3,2,4, 5, 6};
        int i = awesome(array);
        System.out.println(i);

    }

    public static int awesome(int[] array){



        if(array[0]<array[1]){
            return 0;
        }

        if(array[array.length-1]<array[array.length-2]){
            return array.length-1;
        }

        int L = 0;
        int R = array.length-1;

        while (L<R){
            int mid = L+((R-L)>>1);
            // 中间的需要满足，既小于左侧的，又要小于右侧的
            if(array[mid]<array[mid-1] && array[mid]<array[mid+1]){
                return mid;
            }
            if(array[mid]>array[mid-1] ){
                //上扬的线和下降的线一定存在局部最小
                R = mid-1;
            }
            if(array[mid]<array[mid+1]){
                L = mid+1;
            }
        }

        return -1;
    }
}

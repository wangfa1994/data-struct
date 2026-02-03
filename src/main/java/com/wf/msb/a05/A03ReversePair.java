package com.wf.msb.a05;

/*
*  逆序对问题
* 一个数组，遍历数组，存在右侧部分的数，比当前数小，则算一个逆序对。求一个滚在多少个逆序对。
【3,1,0,4,3,1】---->【3,1】【3,0】【3,1】【1,0】【4,3】【4,1】【3,1】
位置0 ，数值为3,存在比3小的值有，1,0,1
位置1，数值为1,存在比1小的值有0
*
* */
public class A03ReversePair {

    public static void main(String[] args) {

        int[] array = new int[]{1,5,9,6,3,4};

         array = new int[]{3,4,5,7,2,8,6,4};

        int a = forSum(array);
        System.out.println(a);
        System.out.println(mergeSort(array,0, array.length-1));

    }

    private static int forSum(int[] array) {

        int count=0;

        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            for (int j =i+1;j<array.length;j++){
                if(array[j]<index){
                    count++;
                }
            }
        }

        return count;
    }

    public static int mergeSort(int[] array,int L,int R){

        if(L == R){
            return 0;
        }
        int mid = L+((R-L)>>1);
        int countL = mergeSort(array, L, mid);
        int countR = mergeSort(array, mid + 1, R);
        int i = mergeSortHelp(array, L, mid, R);
        return countL+countR+i;
    }

    private static int mergeSortHelp(int[] array, int l, int mid, int r) {
        int[] help = new int[r-l+1];

        int index= 0;
        int pointL = l;
        int pointR = mid+1;
        int count = 0;

        while (pointL <= mid && pointR <= r){

            if(array[pointL] < array[pointR]){
                help[index++] = array[pointL++];
            } else if (array[pointL] == array[pointR]) {
               // help[index++] = array[pointR++];
                help[index++] = array[pointL++];
            } else{
                help[index++] = array[pointR++];

                count+= (mid-pointL+1);
            }
        }

        while (pointL<=mid){
            help[index++] = array[pointL++];
        }
        while (pointR<=r){
            help[index++] = array[pointR++];
        }


        for (int i = 0; i < help.length; i++) {
            array[l+i]  = help[i];
        }

        return count;
    }



    // 方式二
    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求逆序对数量返回
    // 所有merge时，产生的逆序对数量，累加，返回
    // 左 排序 merge并产生逆序对数量
    // 右 排序 merge并产生逆序对数量
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // l < r
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int L, int m, int r) {
        int[] help = new int[r - L + 1];
        int i = help.length - 1;
        int p1 = m;
        int p2 = r;
        int res = 0;
        while (p1 >= L && p2 > m) {
            res += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > m) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

}

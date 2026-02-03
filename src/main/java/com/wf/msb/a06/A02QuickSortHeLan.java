package com.wf.msb.a06;

import java.util.Arrays;

public class A02QuickSortHeLan {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,5,6,3,7,9};
        int checkValue = 3;
        heLanWhile(array, checkValue);
        array = new int[]{3,4,6,0,7,4,5,1,3};
        heLan2While(array, checkValue);

    }

    private static void heLan(int[] array, int checkValue) {
        // {3,4,6,0,7,4,5,1,3} ====>[3, 0, 1, 3, 7, 4, 5, 6, 4] 无法将3 进行合到一起
        int minIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= checkValue){
                int temp = array[minIndex + 1];
                array[minIndex + 1] = array[i];
                array[i]=temp;
                minIndex++;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void heLanWhile(int[] array, int checkValue) {

        int index = 0;
        int minIndex=-1;
        while (index<array.length){
            if(array[index] <= checkValue){
                int temp = array[minIndex + 1];
                array[minIndex + 1] = array[index];
                array[index]=temp;
                minIndex++;
            }
            index++;
        }

    }




    private static void heLan2(int[] array, int checkValue) {
        int minIndex = -1;
        int maxIndex = array.length;
        for (int i = 0; i < array.length; i++) {
            if(i==maxIndex) break; // 当指针和右边界装上的时候直接停止，因为到头了
            if(array[i] < checkValue){
                int temp = array[minIndex + 1];
                array[minIndex + 1] = array[i];
                array[i]=temp;
                minIndex++;
            }else if (array[i]> checkValue){
                int temp = array[maxIndex-1];
                array[maxIndex-1] = array[i];
                array[i]=temp;
                maxIndex--;
                i--; //更换过来的值要进行再次判断，大于过来的没有对比过了，小于的可以直接换，移动是因为已经判断过了
            }else {
                // 相等的话不动
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void heLan2While(int[] array, int checkValue) {
        int minIndex = -1;
        int maxIndex = array.length;
        int index = 0;
        while (index<maxIndex){
            if(array[index] < checkValue){
                swap(array,minIndex + 1,index);
                minIndex++;
                index++;
                // swap(index,++minIndex,index++)
            }else if (array[index]> checkValue){
                swap(array,maxIndex-1,index);
                maxIndex--;
            }else {
                // 相等的话不动
                index++;
            }

        }
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int v1,int v2){
        int temp = array[v1];
        array[v1]=array[v2];
        array[v2]=temp;
    }

}

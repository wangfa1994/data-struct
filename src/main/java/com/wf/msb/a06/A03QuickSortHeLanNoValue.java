package com.wf.msb.a06;

import java.util.Arrays;

public class A03QuickSortHeLanNoValue {

    public static void main(String[] args) {


        int[] array = new int[]{1,2,5,3,7,9,6};

        heLanNoValue(array);

        array = new int[]{3,4,6,0,7,4,5,1,3};
        heLanNoValue2(array);

        array = new int[]{3,4,6,0,7,4,5,1,3};
        int[] result = heLanNoValue3(array);
        System.out.println(Arrays.toString(result));

    }
    public static void heLanNoValue(int[] array) {

        int minIndex=-1;
        int cur = 0;
        int value = array[array.length-1];

        while (cur< array.length-1){
            if(array[cur]<value){
                swap(array,minIndex+1,cur);
                minIndex++;
            }
            cur++;
        }
        swap(array,minIndex+1,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void heLanNoValue2(int[] array){

        int minIndex = -1;
        int maxIndex = array.length-1;
        int cur = 0;

        int value = array[array.length-1];

        while (cur<maxIndex){
            int currenValue = array[cur];
            if(currenValue<value){
                swap(array,cur,minIndex+1);
                minIndex++;
                cur++;
            }else if (currenValue>value){
                swap(array,cur,maxIndex-1);
                maxIndex--;
            }else {
                cur++;
            }
        }

        swap(array,maxIndex,array.length-1);

        System.out.println(Arrays.toString(array));

    }

    public static int[] heLanNoValue3(int[] array){

        int minIndex = -1;
        int maxIndex = array.length-1;
        int cur = 0;

        int value = array[array.length-1];

        while (cur<maxIndex){
            int currenValue = array[cur];
            if(currenValue<value){
                swap(array,cur,minIndex+1);
                minIndex++;
                cur++;
            }else if (currenValue>value){
                swap(array,cur,maxIndex-1);
                maxIndex--;
            }else {
                cur++;
            }
        }

        swap(array,maxIndex,array.length-1);

        System.out.println(Arrays.toString(array));

        return new int[]{minIndex+1,maxIndex};

    }



    private static void swap(int[] array, int v1,int v2){
        int temp = array[v1];
        array[v1]=array[v2];
        array[v2]=temp;
    }
}

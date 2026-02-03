package com.wf.msb.a03;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组中，有一种数出现了奇数次，其他数都出现了偶数字，怎么找到并打印这种数。
 *
 * 哈希表可以解决，但是暴力
 * 使用异或运算才是最好的
 */
public class A02EvenOddTimes {

    public static void main(String[] args) {

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);
        printOddTimesNum2(arr1);
        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr1);

    }




    // 哈希表方式
    public static void printOddTimesNum1(int[] array){

       HashMap<Integer, Integer> maps = new HashMap<>();

       for (int i = 0; i < array.length; i++) {
           int i1 = array[i];
           Integer orDefault = maps.getOrDefault(i1, 0);
           maps.put(i1,orDefault+1);
       }
       for (Map.Entry<Integer, Integer> integerIntegerEntry : maps.entrySet()) {
           int i = integerIntegerEntry.getValue() % 2;
           if(i==1){
               System.out.println("找到奇数"+integerIntegerEntry.getKey());
           }
       }

    }


    // 使用异或运算
    private static void printOddTimesNum2(int[] arr2) {
        // 利用异或运算的性质 任何数与0异或都是本身，并且，任何数与自己异或等于0 ，并且结合律和交换律的使用，最后就会剩下一堆0 + 一个奇数 异或
        int eor =0;
        for (int i : arr2) {
            eor = eor ^i;
        }
        System.out.println("找到奇数"+eor);
    }


    // 推演递进，如果找出
}

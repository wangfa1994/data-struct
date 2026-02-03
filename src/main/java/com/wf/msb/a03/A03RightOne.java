package com.wf.msb.a03;

/*
* 怎么把一个int类型的数，提取出最右侧的1来
*
* 利用了与运算  取反+1
*
* */
public class A03RightOne {

    public static void main(String[] args) {

        int i = 13 ;

        int j = i & (~i + 1);

        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(j));

        int m = 0B0000_1010_1100;
        int n =i & (~i + 1);

        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
    }
}

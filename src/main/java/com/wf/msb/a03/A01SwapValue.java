package com.wf.msb.a03;

//  使用异或运算，进行两个值交换，不需要申请额外空间
// 主要是使用了 三个性质 装B使用
public class A01SwapValue {

    public static void main(String[] args) {
        int a= 12 ;
        int b= 13;


        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println(a+"==="+b);

        int i =12;
        int j =i;
        // 指向同一个地址是错误的，会变成0
        i=i^j;
        j=i^j;
        i=i^j;
    }

    public static void swap(int a, int b){
        a=a^b;
        b=a^b;
        a=a^b;
    }
}

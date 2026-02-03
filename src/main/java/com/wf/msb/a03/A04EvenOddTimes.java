package com.wf.msb.a03;

/*
*  一个数组中有两种数出现了奇数次，其他数都出现了偶数字，怎么找到并打印这两种数？
*
*  还是可以利用哈希表处理
* */
public class A04EvenOddTimes {

    public static void main(String[] args) {
        int[] arr1 = { 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum(arr1);
    }

    private static void printOddTimesNum(int[] arrays){

        int eor = 0;

        for (int item : arrays) {
            eor = eor ^ item;
        }

        // 此时eor 一定是 两个数的异或 比如A^B

        // 然后再进行取反，计算出eor的最右侧1的位置，此时1的位上，一定是 A和B在这个位置上吃互斥的，因为异或运算，相同为0，不同为1

        int rightOne = eor &(-eor);

        // 此时数组就可以被分为两个部分，一个这个位置为0的一部分，一个这个位置为1的一部分，并且 A 和 B 属于不同的部分。
        // 此时再次整体循环遍历，计算此值的one位置是否为1，如果为1，进行异或，这样的话，就可以计算区分出来一个值eor2，这个值就为A或者B。
        // 然后利用 eor ^ eor2 就可以得到另外一个值了 ， 因为eor 是 A^B ,而eor2是另外一个，根据性质A^A = 0 ,A^0=A,得到另外一个

        int eor2 = 0;
        for (int item : arrays) {
            /*int onebit = item &(~item +1);
            if(onebit == rightOne){
                //eor2 = eor2^item;
                eor2 = item;
                break;
            }*/

            /*if((item & rightOne) !=0){ //rightOne只有一个1 ，与运算都是1才为1，
                eor2 = eor2^item;
            }*/

        }
        eor = eor2^eor;

        System.out.println("两个数分别为"+eor2+" : "+eor); //3 2

    }
}

package com.wf.msb.a03;

import java.util.HashMap;
import java.util.HashSet;

/*
* 一个数组中有一种数出现了K次，其他数都出现了M次， M>1 K<M ,找到出现了K次的数，额外空间复杂度为O(1) 复杂度O(N)
*
* 数组 array , K=3 , M=5  一个数组中有一种数出现了3次，其他数都出现了5次， M>1 K<M ,找到出现了3次的数
* 【1,1,1,2,2,2,2,2,3,3,3,3,3】
*
* 数组 array , K=2 , M=9  一个数组中有一种数出现了2次，其他数都出现了5次， M>1 K<M ,找到出现了2次的数
*【2,2,5,5,5,5,5,9,9,9,9,9】
*
* * 数组 array , K=2 , M=4  一个数组中有一种数出现了2次，其他数都出现了4次， M>1 K<M ,找到出现了2次的数
 *【2,2,5,5,5,5,9,9,9,9】
*
* 使用数组解决
*
*
*
* */
public class A05KMTimes {


    /*public static void main(String[] args) {

        int[] arr1 = { 1,1,1,2,2,2,2,2,3,3,3,3,3 };int K=3 , M=5;
        System.out.println(bitExecutor(arr1,K,M));

        int[] arr2 = { -1,-1,5,5,5,5,9,9,9,9};int K2=2 , M2=4;

        System.out.println( bitExecutor(arr2,K2,M2));

    }*/

    private static int bitExecutor(int[] arr1,int K,int M) {
        /*int[] arr1 = { 1,1,1,2,2,2,2,2,3,3,3,3,3 };int K=3 , M=5;*/


        // 这个需要利用位运算进行处理，产生一个32位的数组，然后将我们的每一个值都转换为二进制，并且将对应位置的值进行累加到数组中，

        int[] totalCount = new int[32];

        for (int item : arr1) {
            for (int j = 0; j < 32; j++) {
                /*if(((item >>j )& 1) !=0){ // 每次提取出来一位数  确定是否为1
                    totalCount[j] = totalCount[j]+1;
                }*/
                totalCount[j] = totalCount[j]+ ((item >>j) &1);


            }
        }

        // 此时得到的数组，每一个索引上都是都对应的所有的值的二进制再这个位置上的和，
        // 此时我们遍历这个数组，并且用这个值对M取余，如果能被取为0，说明这个位置上一定是被M次的数进行占位，那么这个包含K的值位上一定是0
        // 如果取余不为0，一定是包含了K的值，这个K在这个位置上一定是1
        // 因为  K<M ，所以一定不会包含，取余之后，能把M包含进去的情况。除非这个出现K次的不是唯一的一种

        int result=0;
        for (int j = 0; j < 32; j++) {
            if(totalCount[j]% M !=0){ // 取余
               // result = result |(1<<j);  // 1 向左移动位数之后，进行或运算进入0，就会让位置上的值变成1
                result |= (1 << j); // 或运算进行累加

               // result = result ^ (1<<j);
            }
        }

        //System.out.println("找出数值为："+result);
        return result;
    }



    public static int hashMapExecutor(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int ans = 0;
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                ans = num;
                break;
            }
        }
        return ans;
    }



    // 为了测试
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int ktimeNum = randomNumber(range);
        // 真命天子出现的次数
        int times = k;
        // 2
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        for (; index < times; index++) {
            arr[index] = ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);// 0 ~ N-1
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // 为了测试
    // [-range, +range]
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
    }

    // 为了测试
    public static void main(String[] args) {
        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = hashMapExecutor(arr, k, m);
            int ans2 = bitExecutor(arr, k, m);
            int ans3 = onlyKTimes(arr, k, m);
            if (ans1 != ans2 || ans1 != ans3) {
                System.out.println(ans1);
                System.out.println(ans3);
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }



    public static HashMap<Integer, Integer> map = new HashMap<>();

    // 请保证arr中，只有一种数出现了K次，其他数都出现了M次
    public static int onlyKTimes(int[] arr, int k, int m) {
        if (map.size() == 0) {
            mapCreater(map);
        }
        int[] t = new int[32];
        // t[0] 0位置的1出现了几个
        // t[i] i位置的1出现了几个
        for (int num : arr) {
            while (num != 0) {
                int rightOne = num & (-num);
                t[map.get(rightOne)]++;
                num ^= rightOne;
            }
        }
        int ans = 0;
        // 如果这个出现了K次的数，就是0
        // 那么下面代码中的 : ans |= (1 << i);
        // 就不会发生
        // 那么ans就会一直维持0，最后返回0，也是对的！
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void mapCreater(HashMap<Integer, Integer> map) {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }
}

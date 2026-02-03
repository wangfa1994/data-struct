package com.wf.msb.a06;


/*给定一个数组array，两个整数 lower 和upper，
返回array中有多少个子数组连续的累加和在【low,upper】范围上。
数组【1,-1,-2,3】 累加和范围【-1,1】
*
*
* */
public class A01CountRangeSum {

    public static void main(String[] args) {
        int[] array = new int[]{-2,5,-1};
        array = new int[]{-2147483647,0,-2147483647,2147483647};
        int i = countRangeSum(array, -564, 3864);
        System.out.println(i);
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum+nums[k];
                }
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}

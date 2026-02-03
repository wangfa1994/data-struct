package com.wf.msb.a05;

/**
 * 小和问题
 * 给定一个数组，遍历这个数组，如果数左侧的值都比当前值小，则进行累加，最后求总的和。
 * 【6,3,2,1,6,7】---->【0,0,0,0,6,18】----->24
 * 位置0，左侧比6小的值的和为0.
 * 位置1，左侧比3小的值的和为0，
 * 位置2，左侧比2小的值的和为0
 * 位置3，左侧比1小的值的和为0，
 * 位置4，左侧比6小的值的和为 3 + 2 +1 = 6；
 * 位置5，左侧比7小的值的和为6+3+2+1++=18
 * 最后求得小和值为0+0+0+0+6+18 = 24
 */
public class A02SmallSum {

    public static void main(String[] args) {

        int[] array = new int[]{6, 3, 2, 1, 6, 7};
        array = new int[]{1, 3, 2, 6};
        array = new int[]{4, 3, 5, 7, 2, 8, 6, 4};

        int sum = forSum(array);
        System.out.println(sum);

        System.out.println(forSumMerge(array));
    }

    private static int forSum(int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int index = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] < index) {
                    sum += array[j];
                }
            }
        }
        return sum;

    }

    private static int forSumMerge(int[] array) {
        int sum = 0;

        // 排序，并计算出最小和
        sum = sortMerge(array, 0, array.length - 1);

        return sum;
    }

    private static int sortMerge(int[] array, int L, int R) {

        while (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);

        int sumL = sortMerge(array, L, mid);
        int sumR = sortMerge(array, mid + 1, R);

        int total = sortSum(array, L, mid, R);

        return sumL + sumR + total;
    }

    private static int sortSum(int[] array, int l, int mid, int r) {

        int sum = 0;
        int[] help = new int[r - l + 1];

        int p1 = l;
        int p2 = mid + 1;
        int index = 0;

        while (p1 <= mid && p2 <= r) {

            // 左边的比右边的这个值小，要产生小和
            if (array[p1] < array[p2]) {
                sum = sum + array[p1] * (r - p2 + 1);

                help[index++] = array[p1++];
            } else if (array[p1] == array[p2]) {
                help[index++] = array[p2++];
            } else if (array[p1] > array[p2]) {
                help[index++] = array[p2++];
            }
        }

        while (p1 <= mid) {
            help[index++] = array[p1++];
        }

        while (p2 <= r) {
            help[index++] = array[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            array[l + i] = help[i];
        }

        return sum;

    }
}

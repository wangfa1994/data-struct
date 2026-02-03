package com.wf.msbyuan.class05;

// 这道题直接在leetcode测评：
// https://leetcode.com/problems/count-of-range-sum/
public class Code01_CountOfRangeSum {

	public static int countRangeSum(int[] nums, int lower, int upper) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long[] sum = new long[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		return process(sum, 0, sum.length - 1, lower, upper);
	}


	// 转换成了前缀和数组进行处理原问题
	public static int process(long[] sum, int L, int R, int lower, int upper) {
		if (L == R) { // 判断单个位置是否满足 0-0,1-1,2-2类似的这些
			return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
		}
		// 不止一个位置的进行计算
		int M = L + ((R - L) >> 1);

		int leftSum = process(sum, L, M, lower, upper);
		int rightSum =  process(sum, M + 1, R, lower, upper);
		int mergeSum  = merge(sum, L, M, R, lower, upper)


		return  leftSum+rightSum +mergeSum ;
	}

	public static int merge(long[] arr, int L, int M, int R, int lower, int upper) {

		// 左组右组划定的时候，可以进行右侧中遍历，确定存在多少个子数组的值在(array[i] - upper,array[i]-lower)
		int ans = 0;
		int windowL = L;
		int windowR = L;
		// [windowL, windowR)  因为有序，所以可以不回退的处理，利用窗口，计算出左右两个指针，然后计算指针范围。
		for (int i = M + 1; i <= R; i++) {
			long min = arr[i] - upper; //
			long max = arr[i] - lower;
			while (windowR <= M && arr[windowR] <= max) {
				windowR++;
			}
			while (windowL <= M && arr[windowL] < min) {
				windowL++;
			}
			ans += windowR - windowL; //右侧已经提供了一个值，所以左侧也有一个值，这样的话，计算范围值即可
			ans += Math.max(0,windowR - windowL);
		}

		// 正常merge
		long[] help = new long[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return ans;
	}

}

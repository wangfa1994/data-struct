package com.wf.wangzheng;

import java.util.HashMap;
import java.util.Map;

 // https://leetcode.cn/problems/two-sum/description/
public class A0001两数之和 {

    /** 1. 两数之和 简单
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素
     */

        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>(nums.length);
            int []ret = new int[2];
            for (int i = 0; i < nums.length; i++){
                int a = nums[i];
                int resultB = target - a;
                Integer i1 = map.get(resultB);
                if(i1 ==null){
                    map.put(a,i);
                }else{
                    //匹配成功
                    if(i1>i){
                        ret[0]=i;
                        ret[1]=i1;
                    }else{
                        ret[0]=i1;
                        ret[1]=i;
                    }
                    return ret;
                }

            }
            return ret;
        }
}

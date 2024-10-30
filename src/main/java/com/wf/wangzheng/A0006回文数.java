package com.wf.wangzheng;
 // https://leetcode.cn/problems/palindrome-number/description/
public class A0006回文数 {

    /** 9. 回文数 简单
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数
     * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 例如，121 是回文，而 123 不是。
     */

    class Solution {
        public boolean isPalindrome(int x) {
            if(x < 0)
                return false;
            int cur = 0;
            int num = x;
            while(num != 0) {
                cur = cur * 10 + num % 10; //一步一步扩大十倍再加上个位数
                num /= 10; //一步一步移除个位数
            }
            return cur == x;
        }
    }

}

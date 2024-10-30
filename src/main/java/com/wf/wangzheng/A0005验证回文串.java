package com.wf.wangzheng;

// https://leetcode-cn.com/problems/valid-palindrome/
public class A0005验证回文串 {
    /** 125. 验证回文串 简单
     *  如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     *
     * 字母和数字都属于字母数字字符。
     *
     * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false
     */


        public boolean isPalindrome(String s) {
            // 双指针
            int start=0;int end=s.length()-1;
            while (true){
                if(start>=end) return true;
                char begin = s.charAt(start);
                char tail = s.charAt(end);
                if (Character.isLetterOrDigit(begin) && Character.isLetterOrDigit(tail)){
                    char lowerCaseBegin = Character.toLowerCase(begin);
                    char lowerCaseEnd = Character.toLowerCase(tail);
                    if(lowerCaseEnd != lowerCaseBegin) return false;
                    start++;end--;
                }else{
                    if (!Character.isLetterOrDigit(begin)) {
                        start++;
                    }
                    if (!Character.isLetterOrDigit(tail)) {
                        end--;
                    }
                }
            }

        }
}

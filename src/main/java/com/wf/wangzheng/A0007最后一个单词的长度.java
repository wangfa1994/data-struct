package com.wf.wangzheng;

// [58. 最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)（简单）
public class A0007最后一个单词的长度 {
    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
     * 。
     */


        public int lengthOfLastWord(String s) {
            int len = s.length()-1;
            int retLen = 0;
            while (true){
                if(len<0)return retLen;
                char c = s.charAt(len);
                if(' ' == c){
                    if(retLen == 0){
                        len--;
                        continue;
                    }
                    return retLen;
                }else{
                    retLen++;
                    len--;
                }
            }

        }

}

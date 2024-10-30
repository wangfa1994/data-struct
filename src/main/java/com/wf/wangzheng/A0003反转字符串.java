package com.wf.wangzheng;

//  https://leetcode.cn/problems/reverse-string/description/
public class A0003反转字符串 {
    /** 344. 反转字符串 简单
     *  编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
     *
     */



        // 折半遍历
        public void reverseString(char[] s) {
            int mid = s.length/2;
            int start = 0;
            for (int i = s.length-1; i>=mid;i--){
                char c = s[i];
                s[i]=s[start];
                s[start++]=c;

            }
        }


        // 双指针
        public void reverseString1(char[] s) {
            int start=0,end =s.length-1;
            for (int i = 0;i<s.length;i++){
                if(start>=end){
                    break;
                }else{
                    char star = s[start];
                    s[start++]= s[end];
                    s[end--] =star;
                }
            }
        }


}

package com.wf.wangzheng;
// [剑指 Offer 67. 把字符串转换成整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)（中等）经典atoi()，注意范围越界处理
public class A0011字符转转整数 {

    /**
     *
     *  请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     */

        public int myAtoi(String str) {
            StringBuilder re = new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(' ' == c && re.length() == 0){
                    continue;
                }else{
                    if(('+' ==c || '-' == c) && re.length()==0){
                        re.append(c);
                    }else{
                        if(c>='0'&& c<='9'){
                            re.append(c);
                        }else{
                            String string = re.toString();
                            if((re.length() ==0 ) || ((re.length()==1) &&(re.charAt(0)=='+' || re.charAt(0)=='-')))return 0;
                            try {
                                return Integer.parseInt(string);
                            }catch (Exception e){
                                if(string.charAt(0) == '-') return Integer.MIN_VALUE;
                                return Integer.MAX_VALUE;
                            }
                        }
                    }
                }
            }

            if((re.length() ==0 ) || ((re.length()==1) &&(re.charAt(0)=='+' || re.charAt(0)=='-')))return 0;
            try {
                return Integer.parseInt(re.toString());
            }catch (Exception e){
                if(re.charAt(0) == '-') return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }

        }

    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            StringBuilder re = new StringBuilder("");
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(('+' ==c || '-' == c) && re.length()==0){
                    re.append(c);
                }else{
                    if(c>='0'&& c<='9'){
                        re.append(c);
                    }else{
                        String string = re.toString();
                        if((re.length() ==0 ) || ((re.length()==1) &&(re.charAt(0)=='+' || re.charAt(0)=='-')))return 0;
                        try {
                            return Integer.parseInt(string);
                        }catch (Exception e){
                            if(string.charAt(0) == '-') return Integer.MIN_VALUE;
                            return Integer.MAX_VALUE;
                        }
                    }
                }
            }

            if((re.length() ==0 ) || ((re.length()==1) &&(re.charAt(0)=='+' || re.charAt(0)=='-')))return 0;
            try {
                return Integer.parseInt(re.toString());
            }catch (Exception e){
                if(re.charAt(0) == '-') return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }

        }
    }
}

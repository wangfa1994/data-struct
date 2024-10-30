package com.wf.wangzheng;

// [面试题 01.05. 一次编辑](https://leetcode-cn.com/problems/one-away-lcci/)（中等）
public class A0015一次编辑 {
    /**
     * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     */

     // 双指针更简单


        public boolean oneEditAway(String first, String second) {
            if(first.length()<second.length()){
                String temp = first;
                first = second;
                second = temp;
            }

            // first 长度永远是大的
            int firstLength = first.length();
            int secondLength = second.length();
            if(firstLength - secondLength > 1){
                return false;
            }
            if(firstLength == secondLength){
                //长度相等
                int count = 0;
                for (int i = 0; i < firstLength; i++) {
                    if(first.charAt(i) != second.charAt(i)){
                        count++;
                    }
                }
                return count<=1;
            }

            // 利用短的进行循环，防止下标越界 pale ple 但是会导致最后一个遗漏
            int times = 0;
            int firstIndex = 0;
            int secondIndex = 0;
            if(firstLength == 1 && secondLength == 0) return true;


            for (int i = 0; i < firstLength; i++){ //teacher taches
                char c = first.charAt(firstIndex);
                char c1 = second.charAt(secondIndex);
                if(c !=c1){
                    if(times > 1){
                        return false;
                    }else{
                        firstIndex++;
                    }
                    times++;
                }else {
                    firstIndex++;
                    secondIndex++;
                }

                if(firstIndex == firstLength || secondIndex == secondLength){
                    if(times > 1){
                        return false;
                    }else{
                        return true;
                    }
                }

            }
            return true;

        }
}

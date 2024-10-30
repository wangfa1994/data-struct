package com.wf.algorithm;

/**c
 * @Link https://leetcode.cn/problems/one-away-lcci/
 *
 */
public class Demo {
    /**
     字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     示例 1:
     输入:
     first = "pale"
     second = "ple"
     输出: True


     示例 2:

     输入:
     first = "pales"
     second = "pal"
     输出: False
     */

    public static boolean oneEditAway(String first, String second) {
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


    public static void main(String[] args) throws Exception {

        System.out.println(oneEditAway("islander", "slander"));

        System.out.println(oneEditAway("teacher", "taches"));
        System.out.println(oneEditAway("park", "spake"));

        boolean a0 = oneEditAway("", "b");
        System.out.println(a0);

        boolean a = oneEditAway("a", "b");
        System.out.println(a);
        boolean b = oneEditAway("ab", "bc");
        System.out.println(b);
        boolean c = oneEditAway("pale", "ple");
        System.out.println(c);
        boolean d = oneEditAway("ple", "pale");
        System.out.println(d);

        boolean e = oneEditAway("abcdxabcde", "abcdeabcdx");
        System.out.println(e);

        boolean g = oneEditAway("teacher", "teached");
        System.out.println(g);

    }
}

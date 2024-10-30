package com.wf.wangzheng;

//  https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/description/
public class A0004字符串单词反转 {

    /** LCR 181 字符串中的单词反转 简单
     *  你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转换为正常语序。
     *
     * 注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     */

    public static void main(String[] args) {

        System.out.println(reverseMessage("the sky is blue"));
        System.out.println(reverseMessage("  hello world!  "));
        System.out.println(reverseMessage("a good   example"));

    }



        // 双指针逻辑
        public static String reverseMessage(String message) {
            int start=0;
            int end=message.length()-1;
            StringBuilder stringBuilder = new StringBuilder("");
            char c =' ';
            for (int i = message.length()-1; i >=0 ; i--) {
                if(message.charAt(i) ==' '){
                    // 表示遇到了空格需要进行拆分了
                    start=i;
                    for (int j =start+1;j<=end;j++){
                        stringBuilder.append(message.charAt(j));
                    }
                    if(start !=end) stringBuilder.append(" ");
                    end=i-1;
                }else{
                    //没有遇到空格的情况下，如果是最后一个进行拼接
                    if(i==0){
                        for (int j=0;j<=end;j++){
                            stringBuilder.append(message.charAt(j));
                        }
                    }
                }
            }
            return  stringBuilder.toString().trim();
        }


        // 双指针循环
        public String reverseMessage1(String message) {
            message = message.trim();                               // 删除首尾空格
            int i,j;
            i= j = message.length() - 1;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                while (i >= 0 && message.charAt(i) != ' ') i--;     // 搜索首个空格
                res.append(message.substring(i + 1, j + 1) + " ");  // 添加单词
                while (i >= 0 && message.charAt(i) == ' ') i--;     // 跳过单词间空格
                j = i;                    // j 指向下个单词的尾字符
            }
            return res.toString().trim();     // 转化为字符串并返回
        }



        // StringBuilder
        public String reverseMessage3(String message) {
            StringBuilder returS = new StringBuilder();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = message.length()-1; i >=0 ; i--) {
                char c = message.charAt(i);
                if(c== ' '){
                    if (stringBuilder.length()!=0) {
                        StringBuilder reverse = stringBuilder.reverse();
                        returS.append(reverse).append(" ");
                        stringBuilder=new StringBuilder();
                    }
                }else{
                    stringBuilder.append(c);
                    if(i==0){
                        if (stringBuilder.length()!=0) {
                            StringBuilder reverse = stringBuilder.reverse();
                            returS.append(reverse);
                        }
                    }
                }
            }
            String string = returS.toString();
            return string.endsWith(" ")?string.substring(0,string.length()-1):string;

        }



            // 暴力
            public  String reverseMessage2(String message) {

                String[] arrays =new String[message.length()];
                int index = 0;
                String word="";
                // 变成数组
                for (int i = 0; i < message.length(); i++) {
                    char c = message.charAt(i);
                    if(c ==' '){
                        if(!word.isEmpty()) {
                            arrays[index++]=word;
                            word="";
                        }
                    }else{
                        word+=c;
                        if(i==message.length()-1){
                            arrays[index++]=word;
                            word="";
                        }
                    }

                }

                // 数组转String
                String returnStr = "";
                for (int i = arrays.length - 1; i >=0 ; i--) {
                    String array = arrays[i];
                    if(array==null || array.equals("null")){
                        continue;
                    }
                    if(i==0){
                        returnStr = returnStr + array;
                    }else{
                        returnStr = returnStr + array+" ";
                    }
                }
                return returnStr;
            }



}

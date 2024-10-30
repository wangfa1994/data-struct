package com.wf.wangzheng;
// 8. [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)（简单）
public class A0008替换空格 {

    /**
     LCR 122. 路径加密
     假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
     *
     * 输入：path = "a.aef.qerf.bb"
     *
     * 输出："a aef qerf bb"
     */


        public String pathEncryption(String path) {
            char[] charArray = path.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] == '.'){
                    charArray[i]=' ';
                }
            }
            return new String(charArray);
        }

}

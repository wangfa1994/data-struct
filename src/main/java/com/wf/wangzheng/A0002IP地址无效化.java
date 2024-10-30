package com.wf.wangzheng;

// https://leetcode.cn/problems/defanging-an-ip-address/description/
public class A0002IP地址无效化 {

    /** 1108 地址无效化 简单
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     *
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     *
     */
    public static void main(String[] args) {

        System.out.println(defangIPaddr1("1.1.1.1"));
        System.out.println(defangIPaddr1("255.100.50.0"));
    }


    public String defangIPaddr(String address) {
        String replace = address.replaceAll("\\.", "[.]");
        return replace;
    }

    public static String defangIPaddr1(String address) {
        char[] charArray = address.toCharArray();
        char[] newCharrys = new char[charArray.length+6];

        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c != '.'){
                newCharrys[count] = c;
                count++;
            }else{
                newCharrys[count++] = '[';
                newCharrys[count++] = '.';
                newCharrys[count++] = ']';
            }
        }
        return new String(newCharrys);
    }

}

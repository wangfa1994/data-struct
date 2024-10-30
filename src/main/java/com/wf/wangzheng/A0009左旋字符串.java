package com.wf.wangzheng;

// 9. [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)（简单）有点烦
public class A0009左旋字符串 {
    /**
     * LCR 182. 动态口令
     * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
     *
     * 设定一个正整数目标值 target
     * 将 password 前 target 个字符按原顺序移动至字符串末尾
     * 请返回更新后的密码字符串。

     * 示例 1：
     *
     * 输入: password = "s3cur1tyC0d3", target = 4
     * 输出: "r1tyC0d3s3cu"
     * 示例 2：
     *
     * 输入: password = "lrloseumgh", target = 6
     * 输出: "umghlrlose"
     */

        public String dynamicPassword(String password, int target) {
            char [] newC = new char[password.length()];
            int index = 0;
            for (int i = target; i < password.length(); i++) {
                newC[index++]=password.charAt(i);
            }
            for (int i = 0;i<target;i++){
                newC[index++]=password.charAt(i);
            }
            return new String(newC);
        }

}

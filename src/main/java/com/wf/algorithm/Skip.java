package com.wf.algorithm;

import java.util.Arrays;

public class Skip {
    /**c
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
     * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。返回的长度需要从小到大排列。
     *
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： [3,4,5,6]
     * 解释：
     * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
     */

    public static int[] divingBoard(int shorter, int longer, int k) {

        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        int[] res = new int[k+1];
        int index = 0;
        for (int i =k ;i>=0;i--){
            int i1 = i * shorter + (k - i) * longer;
            res[index++] = i1;
        }
        return res;
    }

    public static int[] divingBoard2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{k * shorter};
        }
        int[] res = new int[k+1];
        computer(shorter,longer,k,res,0);
        return res;
    }
    private static void computer(int shorter, int longer, int k,int[] res,int index){
        if(index>k){
            return;
        }else{
            res[index]=(k-index)*shorter+index*longer;
            computer(shorter,longer,k,res,index+1);
        }
    }




    public static void main(String[] args) throws Exception {
        int[] ints = divingBoard2(1, 2, 3);
        System.out.println(Arrays.toString(ints));

        /*String data = "{\"name\":\"张三\",\"age\":\"18\"}";
        String encrypt = encrypt(data);
        System.out.println("加密后：" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密后：" + decrypt);*/
    }
}

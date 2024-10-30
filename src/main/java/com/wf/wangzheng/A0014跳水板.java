package com.wf.wangzheng;

// [面试题 16.11. 跳水板](https://leetcode-cn.com/problems/diving-board-lcci/)（简单）
public class A0014跳水板 {

    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     *
     * 返回的长度需要从小到大排列
     *
     * 示例 1
     *
     * 输入：
     * shorter = 1
     * longer = 2
     * k = 3
     * 输出： [3,4,5,6]
     * 解释：
     * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
     *
     *  长的依次加一，短的依次减一，组成所有的组合
     *
     *
     */
    // 递归调用
        public int[] divingBoard0(int shorter, int longer, int k) {
            if (k == 0) {
                return new int[0];
            }
            if (shorter == longer) {
                return new int[]{k * shorter};
            }
            int[] res = new int[k+1]; // 结果的大小为什么是k+1
            computer(shorter,longer,k,res,0);
            return res;
        }

        private  void computer(int shorter, int longer, int k,int[] res,int index){
            if(index>k){
                return;
            }else{
                res[index]=(k-index)*shorter+index*longer;
                computer(shorter,longer,k,res,index+1);
            }
        }


        // 循环调用
        public int[] divingBoard(int shorter, int longer, int k) {
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

    /**
     * 为什么是 k+1：
     * 当使用 0 个长跳板时，总长度为 k * shorter。
     * 当使用 1 个长跳板时，总长度为 (k-1) * shorter + longer。
     * 当使用 2 个长跳板时，总长度为 (k-2) * shorter + 2 * longer。
     * 以此类推，直到使用 k 个长跳板时，总长度为 k * longer。
     * 因此，从 0 到 k，共有 k + 1 种不同的组合方式，每种组合方式对应一个不同的总长度。这就是为什么结果数组的长度是 k + 1。
     *
     */

}

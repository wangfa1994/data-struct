package com.wf.wangzheng;

// [面试题 01.08. 零矩阵](https://leetcode-cn.com/problems/zero-matrix-lcci/)（简单）
public class A0012零矩阵 {
    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     *
     *
     * 示例 1：
     *
     * 输入：
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出：
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * 示例 2：
     *
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     */
    // 不能原地换，原地换的话，会导致后续的判断都变成0
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0){
                        row[i] = col[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n; j++) {
                    if(row[i] || col[j]){
                        matrix[i][j]=0;
                    }
                }
            }

        }
    }
}

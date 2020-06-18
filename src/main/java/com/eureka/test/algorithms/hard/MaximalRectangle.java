package com.eureka.test.algorithms.hard;

/**
 * <p> 最大矩形</p>
 * https://leetcode-cn.com/problems/maximal-rectangle/
 *
 * @Author : Eric
 * @Date: 2020-06-18 17:16
 */
public class MaximalRectangle {

    /**
     * 利用 '柱状图中最大的矩形' 解法
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int res = 0;
        LargestRectangleArea l = new LargestRectangleArea();

        int[] tmp = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    tmp[j] += 1;
                } else {
                    // 有断层重新累计
                    tmp[j] = 0;
                }
            }
            res = Math.max(res, l.largestRectangleArea(tmp));
        }

        return res;
    }

    public static void main(String[] args) {
        MaximalRectangle l = new MaximalRectangle();
        char[][] h =
                {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};
        System.out.println(l.maximalRectangle(h));
    }
}

package com.eureka.test.algorithms.normal;

import com.sun.tools.javah.Gen;

import java.util.Arrays;

/**
 * <p>螺旋矩阵2</p>
 * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/spiral-matrix-ii-mo-ni-fa-she-ding-bian-jie-qing-x/
 *
 * @Author : Eric
 * @Date: 2020-05-07 19:00
 */
public class GenerateMatrix {

    /**
     * 整体采用构建矩阵，填充矩阵的思路，填充过程分为四种情况：
     * <p>
     * 从左到右填充一行
     * 从上到下填充一列
     * 从右到左填充一行，注意只有一行的情况
     * 从下到上填充一列，注意只有一列的情况
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int num = 1, sum = n * n;
        while (num <= sum) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }

            b--;
            for (int i = b; i >= t; i--) {
                res[i][l] = num++;
            }
            l++;

        }
        return res;


    }

    public static void main(String[] args) {
        int n = 3;
        GenerateMatrix g = new GenerateMatrix();
        int[][] t = g.generateMatrix(n);
        for (int[] a : t) {
            System.out.println(Arrays.toString(a));
        }
    }
}

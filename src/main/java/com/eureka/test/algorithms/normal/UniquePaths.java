package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>不同路径</p>
 * https://leetcode-cn.com/problems/unique-paths/solution/tu-jie-bu-tong-lu-jing-shu-c-by-vin-18/
 *
 * @Author : Eric
 * @Date: 2020-05-11 20:02
 */
public class UniquePaths {

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * <p>
     * 空间复杂度：O(m * n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {

            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }


    /**
     * 优化1：空间复杂度 O(2n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsTwo(int m, int n) {
        int[] row = new int[m];
        int[] col = new int[m];

        Arrays.fill(row, 1);
        Arrays.fill(col, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                row[j] = row[j - 1] + col[j];
            }
            col = row.clone();
        }
        return row[m - 1];
    }


    /**
     * 优化2：空间复杂度 O(n)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsThr(int m, int n) {
        int[] row = new int[m];

        Arrays.fill(row, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                row[j] += row[j - 1];
            }
        }
        return row[m - 1];
    }

    public static void main(String[] args) {

        UniquePaths p = new UniquePaths();


        System.out.println(p.uniquePathsThr(7, 3));
    }
}

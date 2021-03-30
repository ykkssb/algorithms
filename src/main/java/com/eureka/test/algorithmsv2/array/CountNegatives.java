package com.eureka.test.algorithmsv2.array;

/**
 * <p>1351. 统计有序矩阵中的负数</p>
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * @Author : Eric
 * @Date: 2021-03-27 00:12
 */
public class CountNegatives {

    /**
     * O(n + m) 时间复杂度
     * 、不要暴力法
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = m - 1; i >= 0; i--) {
            int sum = 0;
            while (sum < n && grid[i][sum] >= 0) {
                sum++;
            }
            if (sum == n) {
                return res;
            }
            res += (n - sum);
        }
        return res;
    }

    public static void main(String[] args) {
        CountNegatives cn = new CountNegatives();
        int[][] n = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(cn.countNegatives(n));
    }
}

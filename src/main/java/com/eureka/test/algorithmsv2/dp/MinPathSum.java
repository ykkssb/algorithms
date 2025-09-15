package com.eureka.test.algorithmsv2.dp;

/**
 * <p>最小路径和</p>
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 *
 * @Author : Eric
 * @Date: 2020-05-15 20:02
 */
public class MinPathSum {

    /**
     * 最小路径和 方法 4：动态规划（不需要额外存储空间） 时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。 空间复杂度 ：O(1)不需要额外空间。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] b = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    b[0][0] = grid[0][0];
                } else if (i == 0 ) {
                    b[i][j] = grid[i][j] + b[i][j - 1];
                } else if (j == 0 ) {
                    b[i][j] = grid[i][j] + b[i - 1][j];
                } else {
                    b[i][j] = Math.min(b[i - 1][j], b[i][j - 1])+grid[i][j];
                }
            }
        }
        return b[m - 1][n - 1];

    }

    public static void main(String[] args) {
        MinPathSum p = new MinPathSum();

        int[][] ps = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(p.minPathSum(ps));
    }
}

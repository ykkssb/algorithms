package com.eureka.test.algorithms.normal;

/**
 * <p>最小路径和</p>
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 *
 * @Author : Eric
 * @Date: 2020-05-15 20:02
 */
public class MinPathSum {

    /**
     * 最小路径和
     * 方法 4：动态规划（不需要额外存储空间）
     * 时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。
     * 空间复杂度 ：O(1)不需要额外空间。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;

                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }

            }
        }

        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinPathSum p = new MinPathSum();


        int[][] ps = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(p.minPathSum(ps));
    }
}

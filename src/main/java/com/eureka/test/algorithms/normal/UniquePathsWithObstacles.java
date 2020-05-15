package com.eureka.test.algorithms.normal;

/**
 * <p>不同路径二</p>
 * https://leetcode-cn.com/problems/unique-paths-ii/
 *
 * @Author : Eric
 * @Date: 2020-05-14 19:58
 */
public class UniquePathsWithObstacles {

    /**
     * 方法 1：动态规划
     * <p>
     * 时间复杂度 ：O(M×N)
     * 空间复杂度 ： O(1)
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;


        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        if (dp[0][0] == 0) {
            return 0;
        }

        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {

        UniquePathsWithObstacles p = new UniquePathsWithObstacles();


        int[][] ps = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(p.uniquePathsWithObstacles(ps));


    }
}

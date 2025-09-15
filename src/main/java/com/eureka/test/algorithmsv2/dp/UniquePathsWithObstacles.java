package com.eureka.test.algorithmsv2.dp;

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
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] b= new int[m][n];

        if(obstacleGrid[0][0] ==1){
            return 0;
        }
        b[0][0] = 1;
        // 0 1 00 中间有障碍导致后续都是0
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                b[i][0] = b[i-1][0];
            }
        }
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                b[0][i] = b[0][i-1];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1){
                    b[i][j] = b[i-1][j]+ b[i][j-1];
                }
            }
        }
        return b[m-1][n-1];
    }

    public static void main(String[] args) {

        UniquePathsWithObstacles p = new UniquePathsWithObstacles();


        int[][] ps = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(p.uniquePathsWithObstacles(ps));


    }
}

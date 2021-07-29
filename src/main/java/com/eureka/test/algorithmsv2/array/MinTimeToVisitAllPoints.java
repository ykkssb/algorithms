package com.eureka.test.algorithmsv2.array;

/**
 * <p>1266. 访问所有点的最小时间</p>
 * https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
 *
 * @Author : Eric
 * @Date: 2021-03-24 23:34
 */
public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for(int i=1;i<points[0].length; ++i){
            res += Math.max( Math.abs(points[0][i]-points[0][i-1]), Math.abs(points[1][i]-points[1][i-1]) );
        }
        return res;
    }

    public static void main(String[] args) {
        MinTimeToVisitAllPoints min = new MinTimeToVisitAllPoints();
        int[][] ponit = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(min.minTimeToVisitAllPoints(ponit));
    }
}

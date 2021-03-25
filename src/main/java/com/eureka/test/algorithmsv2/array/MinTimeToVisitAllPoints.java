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
        for (int i = 1; i < points.length; i++) {
            int l = Math.abs(points[i][0] - points[i - 1][0]);
            int r = Math.abs(points[i][1] - points[i - 1][1]);
            res += Math.max(l, r);
        }
        return res;
    }

    public static void main(String[] args) {
        MinTimeToVisitAllPoints min = new MinTimeToVisitAllPoints();
        int[][] ponit = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(min.minTimeToVisitAllPoints(ponit));
    }
}

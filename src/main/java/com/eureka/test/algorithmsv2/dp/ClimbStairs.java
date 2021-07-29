package com.eureka.test.algorithmsv2.dp;

/**
 * <p>爬楼梯</p>
 * https://leetcode-cn.com/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
 *
 * @Author : Eric
 * @Date: 2020-05-26 19:30
 */
public class ClimbStairs {

    /**
     * 标签：动态规划
     * 本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     * <p>
     * 爬上 n-1n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     * 爬上 n-2n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     * </p>
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int[] arr = new int[n + 1];
        arr[n] = 1;
        arr[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = arr[i + 1] + arr[i + 2];

        }
        return arr[0];

    }


    public int climbStairsTwo(int n) {
        double sqt_5 = Math.sqrt(5);
        double res = Math.pow((1 + sqt_5) / 2, n + 1) - Math.pow((1 - sqt_5) / 2, n + 1);
        return (int) (res / sqt_5);
    }

    public static void main(String[] args) {
        ClimbStairs s = new ClimbStairs();
        System.out.println(s.climbStairsTwo(5));
    }
}

package com.eureka.test.algorithmsv2.dp;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 * <p>
 * 746. 使用最小花费爬楼梯
 *
 * @author : yujie.wang
 * @date: 2025-09-29 17:37
 */
public class MinCostClimbingStairs {

    /**
     * todo v1(250929)
     *
     * 推导公式 dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
     *
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        System.out.println(mccs.minCostClimbingStairs(arr));

    }
}

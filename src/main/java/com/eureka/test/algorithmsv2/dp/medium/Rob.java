package com.eureka.test.algorithmsv2.dp.medium;

/**
 * @author : yujie.wang
 * @date: 2025-09-30 17:16
 */
public class Rob {

    /**
     * dp[i]=max(dp[i−2]+nums[i],dp[i−1]) 要求不能相邻,nums[i]只能加 dp[i-2]
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] arr = {2, 1, 1, 1, 1, 9};
        System.out.println(rob.rob(arr));
    }

}
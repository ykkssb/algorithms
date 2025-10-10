package com.eureka.test.algorithmsv2.dp.medium;

/**
 * https://leetcode.cn/problems/house-robber-ii/description/
 * <p>
 * 打家劫舍 II
 *
 * @author : yujie.wang
 * @date: 2025-09-30 17:48
 */
public class RobTwo {

    /**
     * 分别取 (start,end)=(0,n−2) 和 (start,end)=(1,n−1) 进行计算
     * <p>
     * 取两个 dp[end] 中的最大值，即可得到最终结果。
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int ans = Math.max(maxMoney(0, nums.length - 2, nums), maxMoney(1, nums.length - 1, nums));
        return ans;
    }

    int maxMoney(int low, int high, int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = low == 0 ? nums[0] : 0;
        dp[1] = low == 0 ? Math.max(nums[0], nums[1]) : nums[1];
        for (int i = low; i <= high; i++) {
            if (i > 1) {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[high];
    }
}

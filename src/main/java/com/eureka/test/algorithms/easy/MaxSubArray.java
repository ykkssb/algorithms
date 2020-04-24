package com.eureka.test.algorithms.easy;

/**
 * <p>最大子序和</p>
 *
 * @Author : Eric
 * @Date: 2020-04-23 20:08
 */
public class MaxSubArray {

    /**
     * 方法二：贪心
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);

            max = Math.max(cur, max);
        }

        return max;
    }

    /**
     * DP
     *
     * @param nums
     * @return
     */
    public int maxSubArrayTwo(int[] nums) {
        int max = nums[0], n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(nums[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubArray a = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, 1, 5, -6};
//        System.out.println(a.maxSubArrayTwo(nums));
        System.out.println(a.maxSubArray(nums));


    }
}

package com.eureka.test.algorithmsv2.array;

/**
 * <p>面试题 16.17. 连续数列</p>
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-30 22:54
 */
public class MaxSubArray {

    /**
     * todo v2
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int l = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            l = Math.max(l + nums[i], nums[i]);
            res = Math.max(res, l);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray ms = new MaxSubArray();
        int[] s = {-2, 1, -3, 4, -1, 2, 2, -5, 4};
        System.out.println(ms.maxSubArray(s));
    }
}

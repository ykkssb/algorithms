package com.eureka.test.algorithmsv2.array;

/**
 * <p>面试题 17.04. 消失的数字</p>
 * https://leetcode-cn.com/problems/missing-number-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-30 23:27
 */
public class MissingNumber {

    /**
     * 等差数列求和
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
        }
        return (nums.length) * (nums.length + 1) / 2 - sum;
    }

    /**
     * todo v1
     * 2.异或特性
     *
     * 0 ^ x = x
     *
     * 0 ^ x ^ x = 0
     * @param nums
     * @return
     */
    public int missingNumberTwo(int[] nums) {

        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^=  nums[i];
            res ^= i;
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] s = {3, 0, 1};
        System.out.println(mn.missingNumberTwo(s));
    }
}

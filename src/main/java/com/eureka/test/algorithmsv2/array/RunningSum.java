package com.eureka.test.algorithmsv2.array;

/**
 * <p>1480. 一维数组的动态和</p>
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @Author : Eric
 * @Date: 2021-03-22 23:32
 */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for(int i =1 ;i<nums.length;i++){
            res[i] = res[i-1] + nums[i];
        }
        return res;
    }

}

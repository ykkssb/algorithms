package com.eureka.test.algorithmsv2.array;

import java.util.Arrays;

/**
 * <p>561. 数组拆分 I</p>
 *https://leetcode-cn.com/problems/array-partition-i/
 * @Author : Eric
 * @Date: 2021-03-25 23:34
 */
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i<nums.length;i+=2){
            res += nums[i];
        }
        return res;
    }
}

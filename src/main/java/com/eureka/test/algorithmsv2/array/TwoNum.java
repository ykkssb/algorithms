package com.eureka.test.algorithmsv2.array;

import java.util.Arrays;

/**
 *
 1. 两数之和
 * https://leetcode.cn/problems/two-sum/submissions/654905125/
 * @author : yujie.wang
 * @date: 2025-08-20 17:45
 */
public class TwoNum {

    public int[] twoSum(int[] nums, int t) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if ((a + b) == t) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {-3, 2, 3, 6};
        int t = 3;
        TwoNum tw = new TwoNum();

        int[] ints = tw.twoSum(a, t);
        System.out.println(Arrays.toString(ints));
    }
}

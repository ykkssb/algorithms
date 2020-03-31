package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>下一个排列</p>
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @Author : Eric
 * @Date: 2020-03-29 17:46
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = len - 1;
            while(j>=0 && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        // 5-1-1 ，i 为负数
        reverse(nums, i+1);
    }

    public static void reverse(int[] nums, int start) {
        int j = nums.length - 1;
        int i = start;
        while (i < j) {

            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
//        int[] n = {1, 2, 4, 8, 5, 7, 6, 4};
//        int[] n = {5, 1, 1};
        int[] n = {1, 5, 1};
        nextPermutation(n);
        System.out.println(Arrays.toString(n));

        // 1 7654321
        // 2 7654311
    }


}

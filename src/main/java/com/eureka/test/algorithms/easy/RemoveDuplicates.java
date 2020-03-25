package com.eureka.test.algorithms.easy;

/**
 * <p> 删除排序数组中的重复项</p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @Author : Eric
 * @Date: 2020-03-24 18:04
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int res = 0;
        if (nums.length == 0) {
            return res;
        }
        for (int j = 1; j < nums.length; j++) {
            if (nums[res] != nums[j]) {
                nums[++res] = nums[j];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] n = {1, 1, 1, 2, 2, 3, 4, 5};
        System.out.println(removeDuplicates(n));
    }
}

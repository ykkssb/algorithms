package com.eureka.test.algorithmsv2.twopointer;

import java.util.Arrays;

/**
 * <p>26. 删除排序数组中的重复项</p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @Author : Eric
 * @Date: 2021-01-12 10:18
 */
public class RemoveDuplicates {
    /**
     * 双指针计数
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates s = new RemoveDuplicates();
        int[] n = {1, 1, 2};
        System.out.println(s.removeDuplicates(n));

    }
}

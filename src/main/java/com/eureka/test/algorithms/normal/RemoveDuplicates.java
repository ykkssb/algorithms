package com.eureka.test.algorithms.normal;

/**
 * <p>删除排序数组中的重复项贰</p>
 *
 * @Author : Eric
 * @Date: 2020-06-09 19:28
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int index = 1;
        // i 从2 开始
        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 1] != nums[i]) {

                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates s = new RemoveDuplicates();
        int[] nums = {0, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(s.removeDuplicates(nums));
    }
}

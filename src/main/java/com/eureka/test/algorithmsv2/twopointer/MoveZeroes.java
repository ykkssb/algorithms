package com.eureka.test.algorithmsv2.twopointer;

import java.util.Arrays;

/**
 * <p>283. 移动零</p>
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @Author : Eric
 * @Date: 2021-01-14 11:15
 */
public class MoveZeroes {

    /**
     * 双指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[l++] = nums[i];
            }
        }

        for (int j = l; j < nums.length; j++) {
            nums[j] = 0;
        }
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        int[] n = {0, 1, 0, 3, 12};
        m.moveZeroes(n);
    }
}

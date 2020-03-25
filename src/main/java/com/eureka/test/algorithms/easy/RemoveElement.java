package com.eureka.test.algorithms.easy;

/**
 * <p>移除元素</p>
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @Author : Eric
 * @Date: 2020-03-25 19:17
 */
public class RemoveElement {
    /**
     * 方法一：双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 方法二：双指针 —— 当要删除的元素很少时
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementTwo(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 3, 1, 5};
        System.out.println(removeElementTwo(n, 3));
    }
}

package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>在排序数组中查找元素的第一个和最后一个位置</p>
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @Author : Eric
 * @Date: 2020-04-01 20:10
 */
public class SearchRange {

    /**
     * 方法 2：二分查找
     * 时间复杂度： O(\log_{2}n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int s1 = test(nums, target, true);
        if (s1 == nums.length || nums[s1] != target) {
            return ans;
        }
        ans[0] = s1;
        ans[1] = test(nums, target, false) - 1;

        return ans;
    }

    public static int test(int[] nums, int target, Boolean left) {
        int len = nums.length;
        int l = 0, r = len;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid] || (left && target == nums[mid])) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(searchRange(n, 4)));
    }
}

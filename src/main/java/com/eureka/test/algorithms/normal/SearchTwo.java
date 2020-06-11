package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>搜索旋转排序数组二</p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @Author : Eric
 * @Date: 2020-06-10 17:57
 */
public class SearchTwo {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);

        if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return false;
        }
        int l = 0, r = nums.length - 1;
        int mid = l + (r - l) / 2;

        while (l <= r) {
            if (nums[mid] == target) {
                return true;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[r] >= target && nums[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            mid = l + (r - l) / 2;
        }

        return false;
    }

    public static void main(String[] args) {

        SearchTwo s = new SearchTwo();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};

        System.out.println(s.search(nums, 0));
    }

}

package com.eureka.test.algorithms.normal;

/**
 * <p>搜索旋转排序数组</p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @Author : Eric
 * @Date: 2020-03-31 18:01
 */
public class SearchNums {

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;

                } else {
                    r = mid - 1;
                }
            }
            mid = l + (r - l) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] n = {5, 6, 7, 8, 1, 2, 3, 4, 5};
        int target = 1;
        System.out.println(search(n, target));
    }
}

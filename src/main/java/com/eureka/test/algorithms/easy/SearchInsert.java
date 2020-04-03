package com.eureka.test.algorithms.easy;

/**
 * <p>搜索插入位置</p>
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @Author : Eric
 * @Date: 2020-04-02 19:45
 */
public class SearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        return get(nums, target);
    }

    public static int get(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len;
        int mid = l + (r - l) / 2;
        while (l < r) {
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = l + (r - l) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] n = {1, 3, 5, 7, 9};
        int target = 10;
        System.out.println(get(n, target));
//        System.out.println(searchInsert(n, target));
    }
}

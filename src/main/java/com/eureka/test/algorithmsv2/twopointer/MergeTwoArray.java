package com.eureka.test.algorithmsv2.twopointer;

import java.util.Arrays;

/**
 * <p>88. 合并两个有序数组</p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @Author : Eric
 * @Date: 2021-01-12 11:25
 */
public class MergeTwoArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1, l2 = n - 1, len = m + n - 1;
        while (l1 >= 0 && l2 >= 0) {
            nums1[len--] = nums1[l1] > nums2[l2] ?
                    nums1[l1--] : nums2[l2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, l2 + 1);
        Arrays.stream(nums1).forEach(System.out::println);

    }

    //1223 5
    public static void main(String[] args) {
        int[] n1 = {2, 2, 3, 0, 0, 0};
        int[] n2 = {1, 5, 6};

        MergeTwoArray m = new MergeTwoArray();
        m.merge(n1, 3, n2, 3);
    }
}
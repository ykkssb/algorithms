package com.eureka.test.algorithms.easy;

import java.util.Arrays;

/**
 * <p>合并两个有序数组</p>
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @Author : Eric
 * @Date: 2020-06-17 18:24
 */
public class MergeNum {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1, p2 = n - 1;
        int len = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[len--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        //{0} ,{1} add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(1);
    }

    public static void main(String[] args) {
        /** 1,2,5, 0,0,0,
         * 2,3,4
         *  125 345
         **/


        MergeNum m = new MergeNum();
        int[] m1 = {1, 2, 5, 0, 0, 0};
        int[] m2 = {2, 3, 4};
        m.merge(m1, 3, m2, 3);
    }


}

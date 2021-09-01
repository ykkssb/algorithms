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
    /**
     * todo v3 -> v2 ->v3
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len =m+n-1 , r= n-1 , l =m-1;
        while(l>=0 && r>=0){
            nums1[len--] =  nums1[l] > nums2[r] ? nums1[l--] : nums2[r--];

        }
        System.arraycopy(nums2, 0 ,nums1, 0, r+1);

    }

    public void mergeTwo(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = n - 1, len = m + n - 1;

        while (len >= 0 && l >= 0 && r >= 0) {
            if (nums1[l] > nums2[r]) {
                nums1[len--] = nums1[l--];
            } else {
                nums1[len--] = nums2[r--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, r + 1);
        Arrays.stream(nums1).forEach(System.out::println);

    }

    //1223 5
    public static void main(String[] args) {
        int[] n1 = {40, 41, 51, 0, 0, 0};
        int[] n2 = {1, 2, 3};

        MergeTwoArray m = new MergeTwoArray();
        m.merge(n1, 3, n2, 3);

        System.out.println("排序后:");
        Arrays.stream(n1).forEach(System.out::println);

    }
}
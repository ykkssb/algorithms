package com.eureka.test.algorithmsv2.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

/**
 * <p>977. 有序数组的平方</p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @Author : Eric
 * @Date: 2021-01-15 19:00
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return nums;
        }
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[i] * nums[i];
        }

        Arrays.sort(n);
        return n;
    }

    public static void main(String[] args) {

        SortedSquares ss = new SortedSquares();
        int[] n = {-4, -1, 0, 3, 10};

        Arrays.stream(ss.sortedSquares(n)).forEach(System.out::println);
    }
}

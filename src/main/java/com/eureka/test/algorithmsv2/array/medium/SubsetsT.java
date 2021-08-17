package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>子集</p>
 * https://leetcode-cn.com/problems/subsets/
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * @Author : Eric
 * @Date: 2020-06-05 17:58
 */
public class SubsetsT {
    /**
     * 思路一：
     * 集合的每个元素，都有可以选或不选，用二进制和位运算
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> ret = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    ret.add(nums[j]);
                }
            }
            res.add(ret);

        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsTwo(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            back(0, i, nums, list);
        }
        return res;
    }

    public void back(int index, int len, int[] nums, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            back(i + 1, len, nums, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        SubsetsT s = new SubsetsT();
        int[] nums = {1, 2, 3, 4};
        System.out.println(s.subsets(nums));
//        System.out.println(((4 >> 0) & 1) == 1);

    }
}

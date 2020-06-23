package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>子集 II</p>
 * https://leetcode-cn.com/problems/subsets-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-19/
 *
 * @Author : Eric
 * @Date: 2020-06-23 16:43
 */
public class SubsetsWithDup {

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 回溯
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            sum(0, i, ans, nums);
        }
        return res;
    }

    public void sum(int cur, int index, List<Integer> list, int[] nums) {
        if (list.size() == index) {
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = cur; i < nums.length; i++) {
            //i>cur下表越界
            if (i > cur && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            sum(i + 1, index, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] nums = {1, 2, 2};
        System.out.println(s.subsetsWithDup(nums));

    }
}

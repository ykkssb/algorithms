package com.eureka.test.algorithms.normal;

import java.util.*;

/**
 * <p>组合数列二</p>
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 *
 * @Author : Eric
 * @Date: 2020-04-15 18:01
 */
public class PermuteTwo {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();

        boolean[] b = new boolean[nums.length];

        Arrays.sort(nums);
        get(tmp, res, nums, b);
        return res;
    }

    public void get(Deque<Integer> tmp, List<List<Integer>> res, int[] nums, boolean[] b) {

        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }

        for (int i = 0; i < nums.length; i++) {

            if (b[i] == true) {
                continue;
            }

//            if (i > 0 && nums[i - 1] == nums[i] && b[i - 1]) {
            if (i > 0 && nums[i - 1] == nums[i] && !b[i - 1]) {
                continue;

            }

            b[i] = true;
            tmp.add(nums[i]);

            get(tmp, res, nums, b);
            b[i] = false;
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteTwo p = new PermuteTwo();
        int[] n = {1, 2, 1};
        System.out.println(p.permute(n));
    }
}

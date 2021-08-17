package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>46. 全排列</p>
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/
 * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 *
 * @Author : Eric
 * @Date: 2020-04-13 17:58
 */
public class Permute {
    /**
     * 回溯法 todo v2
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] bo = new boolean[nums.length];

        back(res, new ArrayList<>(), nums, bo);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] bo) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (bo[i]) {
                continue;
            }
            bo[i] = true;
            list.add(nums[i]);
            back(res, list, nums, bo);
            bo[i] = false;

            list.remove(list.size() - 1);
        }
    }

    /**
     * 交换法 难理解 2021年08月08日00:33:26
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteTwo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        rec(res, list, nums.length, 0);
        return res;
    }

    public void rec(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (start == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {

            Collections.swap(list, start, i);
            rec(res, list, n, start + 1);
            Collections.swap(list, start, i);
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] n = {1, 2, 3};
        System.out.println(p.permuteTwo(n));
    }
}

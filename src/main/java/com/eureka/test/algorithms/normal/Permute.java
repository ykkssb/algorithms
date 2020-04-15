package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>全排列</p>
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/
 *
 * @Author : Eric
 * @Date: 2020-04-13 17:58
 */
public class Permute {
    /**
     * 回溯法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        boolean[] valid = new boolean[nums.length];
        back(tmp, nums, res, valid);
        return res;
    }

    public void back(ArrayList<Integer> tmp, int[] nums, List<List<Integer>> res, boolean[] valid) {

        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (valid[i] == true) {
                continue;
            }
            valid[i] = true;
            tmp.add(nums[i]);
            back(tmp, nums, res, valid);

            valid[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] n = {1, 3, 1};
        System.out.println(p.permute(n));
    }
}

package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : yujie.wang
 * @date: 2025-08-27 15:53
 */
public class Permute2 {
    List<List<Integer>>  ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] bo = new boolean[nums .length];
        dfs(0,nums, bo , new ArrayDeque<>());
        return ans;
    }
    void dfs(int start, int[] nums, boolean[] bo, Deque<Integer > dq) {
        if (nums.length < dq.size()) {
            return;
        } else if (dq.size() == nums.length) {
            ans.add(new ArrayList<>(dq));
        }
        for (int i = start; i < nums.length; i++) {
            if (bo[i]) {
                continue;
            }
            bo[i] = true;
            dq.add(nums[i]);
            dfs(i, nums, bo, dq);
            bo[i] = false;
            dq.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute2 p = new Permute2();
        int[] n = {1, 1, 2};
        System.out.println(p.permuteUnique(n).toString());
    }
}

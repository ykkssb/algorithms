package com.eureka.test.algorithmsv2.array.medium;

import java.util.*;

/**
 * <p>组合总和二</p>
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/xiang-xi-jiang-jie-ru-he-bi-mian-zhong-fu-by-allen/
 *
 * @Author : Eric
 * @Date: 2020-04-06 21:09
 */
public class CombinationSum2 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0 || target < -1) {
            return ans;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        process(0, candidates, target, path);
        return ans;
    }

    public void process(int start, int[] n, int target, Deque<Integer> path) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < n.length; i++) {

                //  1 2 2 2 2 5  过滤掉第二个122 122
                // todo v2(250929) i > start
                // i:3>2 c, 2>1 c, 3>1 c
                if (i > start && n[i] == n[i - 1]) {
                    continue;

                }
                path.add(n[i]);
                process(i + 1, n, target - n[i], path);
                path.removeLast();
            }
        }

    }

    /**
     * 223,23
     *
     * @param args
     */
    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        int[] n = {1, 2,2,2,5};
        System.out.println((c.combinationSum2(n, 5)).toString());
    }
}

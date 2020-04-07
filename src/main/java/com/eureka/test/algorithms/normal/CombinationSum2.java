package com.eureka.test.algorithms.normal;

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
        process(0, candidates, target, path, 0);
        return ans;
    }

    public void process(int start, int[] n, int target, Deque<Integer> path, int cur) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < n.length; i++) {

                // cur 代码层级
                if (i > cur && n[i] == n[i - 1]) {
                    continue;

                }
                path.add(n[i]);
                process(i + 1, n, target - n[i], path, i + 1);
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
        int[] n = {1, 1, 2, 2, 6, 7, 7, 10};
        System.out.println((c.combinationSum2(n, 8)).toString());
    }
}

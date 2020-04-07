package com.eureka.test.algorithms.normal;

import java.util.*;

/**
 * <p>组合总和</p>
 * https://leetcode-cn.com/problems/combination-sum/solution/chao-qiang-gifzhu-ni-shi-yong-dong-tai-gui-hua-qiu/
 *
 * @Author : Eric
 * @Date: 2020-04-05 21:31
 */
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 回溯算法 + 剪枝
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return ans;
        }

        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        process(0, candidates, target, new ArrayDeque<>());
        return ans;
    }

    public void process(int start, int[] n, int target, Deque<Integer> path) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new ArrayList<>(path));
        } else {
            for (int i = start; i < n.length; i++) {
                path.add(n[i]);
                process(i, n, target - n[i], path);
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
        CombinationSum c = new CombinationSum();
        int[] n = {2, 3, 5};
        System.out.println((c.combinationSum(n, 7)).toString());
    }
}

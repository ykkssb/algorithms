package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>面试题 08.04. 幂集</p>
 * https://leetcode-cn.com/problems/power-set-lcci/solution/hui-su-wei-yun-suan-deng-gong-4chong-fang-shi-jie-/
 *
 * @Author : Eric
 * @Date: 2021-03-29 23:10
 */
public class Subsets {

    /**
     * todo v2
     * 1，非递归解决
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int num = res.size();

            for (int j = 0; j < num; j++) {
                List<Integer> t = new ArrayList<>(res.get(j));
                t.add(nums[i]);
                res.add(t);
            }
        }
        return res;
    }

    /**
     * 2，回溯法解决  todo v4
     * 它想象成为一颗n叉树，通过DFS遍历这棵n叉树，他所走过的所有路径都是子集的一部分
     */
    public List<List<Integer>> subsetsTwo(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> list, int[] nums, Integer start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            back(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 位运算解决 todo v1
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsThree(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int l = 1 << nums.length;
        for (int i = 1; i < l; i++) {

            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(((1<<j) & i) !=0)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 递归 todo v2
     * 生成一个2^n长的数组，数组的值从0到(2^n)-1。我们可以把它想象成为一颗二叉树，每个节点的子树都是一个可选一个不可选
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsFour(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        trans(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void trans(List<List<Integer>> res, List<Integer> list, int[] nums, int len) {
        if (len == nums.length) {
            res.add(list);
            return;
        }
        trans(res, new ArrayList<>(list), nums, len + 1);
        list.add(nums[len]);
        trans(res, new ArrayList<>(list), nums, len + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        Subsets ss = new Subsets();
        int[] n = {1, 2, 3};
//        System.out.println(ss.subsets(n));
//        System.out.println(ss.subsetsThree(n));
//        System.out.println(ss.subsetTwo(n));
        System.out.println(ss.subsetsFour(n));
    }
}

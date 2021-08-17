package com.eureka.test.algorithmsv2.array.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>组合</p>
 * https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * @Author : Eric
 * @Date: 2020-06-03 19:42
 */
public class Combine {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        if (n == 0 || k == 0) {
            return res;
        }
        Stack<Integer> st = new Stack<>();

        fill(n, k, 1, st);
        return res;
    }

    /**
     * todo v1
     * @param n
     * @param k
     * @param index
     * @param st
     */
    public void fill(int n, int k, int index, Stack<Integer> st) {

        if (st.size() == k) {
            res.add(new ArrayList<>(st));
            return;
        }

        for (int i = index; i <= n - k + st.size()+1; i++) {
            st.push(i);
            fill(n, k, i + 1, st);
            st.pop();

        }
    }

    public static void main(String[] args) {
        Combine c = new Combine();
        // 1,2,3,4
        System.out.println(c.combine(4, 2));
    }
}

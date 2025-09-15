package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>生成括号</p>
 * https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 *
 * @Author : Eric
 * @Date: 2020-03-21 20:18
 */
public class GenerateParenthesis {

    /**
     * 方法二：回溯法 深度优先遍历(加、减两种方式)
     *
     * @param n
     * @return
     */
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    void dfs(String s, int l, int r) {

        if (l == 0 && r == 0) {
            ans.add(s);
            return;
        }
        if (l > r) {
            return;
        }

        if (l > 0) {
            dfs(s + "(", l - 1, r);
        }

        if (r > 0) {
            dfs(s + ")", l, r - 1);
        }

    }


    class Node {

        private String res;

        private int left;

        private int right;

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 广度优先遍历
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisTwo(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                ans.add(curNode.res);
            }

            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }

            if (curNode.right > 0 && curNode.left <= curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesisTwo(3));
    }
}

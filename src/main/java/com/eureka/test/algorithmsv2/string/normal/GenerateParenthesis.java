package com.eureka.test.algorithmsv2.string.normal;

import com.eureka.test.container.Dnode;

import java.util.*;

/**
 * <p>面试题 08.09. 括号</p>
 * https://leetcode-cn.com/problems/bracket-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-01 17:29
 */
public class GenerateParenthesis {

    /**
     * 深度优先遍历
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String s, int l, int r, List<String> res) {

        if (l == 0 && r == 0) {
            res.add(s);
            return;
        }

        if (l > r) {
            return;
        }

        if (l > 0) {
            dfs(s + "(", l - 1, r, res);
        }

        if (r > 0) {
            dfs(s + ")", l, r - 1, res);
        }
    }

    /**
     * 广度优先遍历
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisTwo(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Deque<Node> st = new ArrayDeque<>();
        st.add(new Node("", n, n));
        while (!st.isEmpty()) {
            Node s = st.removeFirst();
            if (s.left == 0 && s.right == 0) {
                res.add(s.res);
            }

            if(s.left>s.right){
                continue;
            }
            if (s.left > 0) {
                st.add(new Node(s.res + "(", s.left - 1, s.right));
            }

            if (s.right > 0) {
                st.add(new Node(s.res + ")", s.left, s.right - 1));

            }

        }

        return res;
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

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesisTwo(2));

    }

}

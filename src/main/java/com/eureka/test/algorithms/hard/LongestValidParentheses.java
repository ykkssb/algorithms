package com.eureka.test.algorithms.hard;

import java.util.Stack;

/**
 * <p>最长有效括号</p>
 *
 * @Author : Eric
 * @Date: 2020-03-30 18:41
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int ans = 0;
        if (len == 0) {
            return ans;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "(())";

        System.out.println(longestValidParentheses(s));
    }
}

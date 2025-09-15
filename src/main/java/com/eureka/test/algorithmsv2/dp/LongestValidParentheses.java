package com.eureka.test.algorithmsv2.dp;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=problem-list-v2&envId=dynamic-programming
 * <p>最长有效括号</p>
 *
 * @Author : Eric
 * @Date: 2020-03-30 18:41
 */
public class LongestValidParentheses {

    /**
     * 栈 先进后出
      * @param s
     * @return
     */
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

    /**
     * 方法三：不需要额外的空间方法三：不需要额外的空间
     */
    public int longestValidParenthesesTwo(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                ans = Math.max(ans, 2 * r);
            } else if (r > l) {
                l = r = 0;
            }
        }
        l = r = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                ans = Math.max(ans, 2 * r);
            } else if (l > r) {
                l = r = 0;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "(()";

        System.out.println(longestValidParentheses(s));
    }
}

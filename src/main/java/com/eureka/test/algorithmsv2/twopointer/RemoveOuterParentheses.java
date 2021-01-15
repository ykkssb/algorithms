package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>删除最外层的括号</p>
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 *
 * @Author : Eric
 * @Date: 2021-01-11 11:04
 */
public class RemoveOuterParentheses {

    /**
     * 方法1：双指针计数
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses1(String S) {
        StringBuilder res = new StringBuilder();
        int count = 0, l = 0;
        char[] s = S.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                count++;
            } else if (s[i] == ')') {
                count--;
            }
            if (count == 0) {
                res.append(S.substring(l + 1, i));
                l = i + 1;
            }
        }
        return res.toString();
    }

    /**
     * 方法2：单指针计数
     */
    public String removeOuterParentheses2(String S) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                count--;
            }
            if (count >= 1) {
                sb.append(c);
            }
            if (c == '(') {
                count++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s =
                "(()())(())";
        RemoveOuterParentheses s1 = new RemoveOuterParentheses();
        System.out.println(s1.removeOuterParentheses1(s));

//        System.out.println(s.substring(1, 5));
    }
}

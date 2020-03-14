package com.eureka.test.algorithms.hard;

/**
 * <p>正则表达式匹配</p>
 * https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode/
 *
 * @Author : Eric
 * @Date: 2020-03-14 13:44
 */
public class IsMatch {
    /**
     * 方法一：回溯法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        // 点睛之笔
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) ||
                p.charAt(0) == '.'));

        if (p.length() > 1 && p.charAt(1) == '*') {

            return first_match && (isMatch(s.substring(1), p)) ||
                    isMatch(s, p.substring(2));

        } else {

            return first_match && (isMatch(s.substring(1), p.substring(1)));
        }

    }

    /**
     * 动态规划
     * 自底向上的方法
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatchTwo(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {

                boolean first_match = (i < s.length() &&
                        (s.charAt(i) == p.charAt(j) ||
                                p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }

            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        String p = "a*";
//        System.out.println("==:" +p.substring(2));
        System.out.println(isMatchTwo(s, p));
    }
}

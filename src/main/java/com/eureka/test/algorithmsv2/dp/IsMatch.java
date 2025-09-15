package com.eureka.test.algorithmsv2.dp;

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
     * 动态规划 自底向上的方法
     *   *（星号）:
     * 表示前面的字符可以出现零次或多次。
     * 例如，正则表达式 ab*c 可以匹配 ac、abc、abbc、abbbc 等。
     *
     * a1-例子：s="aab", p="aabb*", 干掉“b*”，p' = "aab" == s；所以，干掉“b*”，相当于*让第2个b重复0次（即抹掉了第二个b），属于a1情况，这种情况就是，不看p串的末尾两个，就看p(0,j-3)与s(0,i-1)是否相同，相同就是true。此种情况下，推导公式为：dp(i)(j) = dp(i)(j-2)
     *
     * a2-例子：s="aab",p="aab*"，p(j-1)="*",p(j-2)==s(i-1)=b，*使得b重复1次，属于a2描述情况。此种情况，有两种方法：
     *
     * <1> 仅干掉p串末尾的“*”，看p(0,j-2)与s(0,i-1)是否相同，此时，推导公式为：dp(i)(j) = dp(i)(j-1)；
     *
     * <2> 已知p末尾的*重复它前一个字符去匹配了s串末尾的一个字符。所以，可以同时干掉p串末尾两个字符和s末尾1个字符，看剩下的p(0,j-3)与s(0,j-2)是否相同。此时，推导公式为：dp(i)(j) = dp(i-1)(j-2);
     *
     * 【注】所以，网上的题解会看到两种状态转移的公式，其实分析明白了，两种都可以得到正确的解（都是一样的）。本文选择的是第2种方法的推导公式，即dp(i)(j) = dp(i-1)(j-2)
     *
     * a3-例子: s="aabb"（或s="aabbb"都行）,p="aab*"。不难看出，p末尾的*使得b重复了2次（或3次），符合情况a3。这种情况，已知s(i-1)=p(j-2)，*使得p(j-2)这个字符重复1次匹配了s(i-1)，*能不能使得p(j-2)再与s(i-2)字符继续匹配，那就把s串的末尾字符去掉，查看p(0,j-1)能否继续与s(0,i-2)匹配了。此时，推导公式为：dp(i)(j) = dp(i-1)(j)
     *
     * 【注】对了，依据此文各情况分支的讨论，此分支dp(i)(j) 是a1~a3三种情况的“或运算”，即dp(i)(j) = dp(i)(j-2) || dp(i-1)(j-2) || dp(i-1)(j) 。
     */
    public boolean isMatchTwo(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    /**
                     *  aab 和 aabb* 返回是 true
                     *   j 代表的是* 的后一位
                     *   f[][j] = f[][j-2] j-2代表干掉 b*
                       */
                    f[i][j] = f[i][j - 2];
                    // todo 这里传入的是 j-1 代表*
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                        // f[i - 1][j] aabbbbbb 和 aab*  已知i-1和 j-2 相等 b重复多次传递 true
                        // 两种都可以
//                        f[i][j] = f[i][j] || f[i - 1][j]||f[i-1][j-2];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "aabb*";
        IsMatch im = new IsMatch();
        System.out.println(im.isMatchTwo(s, p));
//        System.out.println("==:" +p.substring(2));
    }


}

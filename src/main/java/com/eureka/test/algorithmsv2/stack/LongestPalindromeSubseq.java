package com.eureka.test.algorithmsv2.stack;

/**
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 * 最长回文子序列
 * @author : yujie.wang
 * @date: 2025-09-01 17:46
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] b = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            b[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                        // bcab  b和 b 一样 肯定加2
                        b[i][j] = b[i+1][j-1]+2;
                } else {
                        // aba abcdba
                        // 特殊处理 bcab
                        //  1 1 1 3
                        //  0 1 1 1 bab 不跳过最长
                        //  0 0 1 1
                        //  0 0 0 1
                        b[i][j] = Math.max(b[i + 1][j], b[i][j-1]) ;
                }
            }
        }
        // abbca
        return b[0][n-1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq l = new LongestPalindromeSubseq();
        String s = "abbca";
        System.out.println(l.longestPalindromeSubseq(s));
    }
}


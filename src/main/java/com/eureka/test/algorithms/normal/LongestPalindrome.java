package com.eureka.test.algorithms.normal;

/**
 * <p>最长回文子串</p>
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @Author : Eric
 * @Date: 2020-03-07 21:42
 */
public class LongestPalindrome {

    /**
     * 暴力法
     * 时间复杂度：O(n^3)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        int max = 0;
        String ans = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > max) {
                    ans = test;
                    max = ans.length();
                }
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {

        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法 3: 暴力破解优化
     * 时间复杂度: 两层循环 O(n²）
     * <p>
     * 空间复杂度：用二维数组 P 保存每个子串的情况 O(n)
     *
     * @param s
     */
    public static String longestPalindromeTwo(String s) {
        int n = s.length();
        boolean[] p = new boolean[n];
        String max = "";
        for (int i = n - 1; i > 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                //j - i 代表长度减去 1
                p[j] = (s.charAt(i) == s.charAt(j)) && (j - i < 1 || p[j - 1]);
                if (p[j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }

        return max;

    }

    /**
     * 解法 4: 扩展中心
     * 我们知道回文串一定是对称的，所以我们可以每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可
     * <p>
     * 时间复杂度：O(n²）
     * <p>
     * 空间复杂度：O(1）
     *
     * @param s
     * @return
     */
    public static String longestPalindromeThree(String s) {
        if (s == null) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = expandAroundCenter(s, i, i);
            int b = expandAroundCenter(s, i, i + 1);
            int max = Math.max(a, b);
            if (max > end - start) {
                //max -1 是为了abba 这种情况max =2
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 马拉车算法mancher
     *
     * @param s
     */
    public static String longestPalindromeFour(String s) {
        int n = s.length();
        String ans = "";

        return ans;
    }


    public static void main(String[] args) {
        String abc = "abba";
//        System.out.println(abc.substring(2, 6));
//        System.out.println(longestPalindromeTwo(abc));‰
        System.out.println(longestPalindromeThree(abc));
    }
}

package com.eureka.test.algorithms.easy;

/**
 * <p>实现strStr（）</p>
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @Author : Eric
 * @Date: 2020-03-26 19:15
 */
public class StrStr {

    /**
     * 方法一：子串逐一比较 - 线性时间复杂度
     * 时间复杂度：O((N - L)L)
     * 空间复杂度：O(1)
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int L = haystack.length(), N = needle.length();
        if (needle == null || needle == "") {
            return 0;
        } else if (N > L) {
            return -1;
        }

        int s = -1;
        for (int i = 0; i < L - N + 1; ++i) {
            if (haystack.substring(i, i + N).equals(needle)) {
                return s = i;
            }
        }

        return s;
    }

    public static int strStrTwo(String haystack, String needle) {
        int L = haystack.length(), N = needle.length();
        if (N > L) {
            return -1;
        } else if (L == 0 || N == 0) {
            return 0;
        }

        int p = 0;
        while (p < L - N + 1) {

            while (p < L - N + 1 && needle.charAt(0) != haystack.charAt(p)) {
                p++;
            }

            int pn = 0;
            int cur = 0;
            while (pn < N && p < L && needle.charAt(pn) == haystack.charAt(p)) {
                p++;
                pn++;
                cur++;
            }

            if (cur == N) {
                return p - cur;

            }
            p = p - cur + 1;
        }
        return -1;
    }

    /**
     * 方法三： Rabin Karp - 常数复杂度
     * todo
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrT(String haystack, String needle) {
        int N = needle.length(), L = haystack.length();
        if (N > L) return -1;

        int a = 26;
        long modulus = (long) Math.pow(2, 31);

        long h = 0, ref_h = 0;
        for (int i = 0; i < N; ++i) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
        }
        if (h == ref_h) return 0;

        long aL = 1;
        for (int i = 1; i <= N; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < L - N + 1; ++start) {
            h = (h * a - charToInt(start - 1, haystack) * aL
                    + charToInt(start + N - 1, haystack)) % modulus;
            if (h == ref_h) return start;
        }
        return -1;
    }


    public static int charToInt(int idx, String s) {
        return (int) s.charAt(idx) - (int) 'a';
    }


    public static void main(String[] args) {


        String l = "mississippi";
        String n = "issip";
        System.out.println(strStrT(l, n));
    }
}

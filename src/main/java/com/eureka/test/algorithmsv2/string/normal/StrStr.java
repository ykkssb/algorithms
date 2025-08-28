package com.eureka.test.algorithmsv2.string.normal;

/**
 * 28. 找出字符串中第一个匹配项的下标 https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=problem-list-v2&envId=string
 *
 * @author : yujie.wang
 * @date: 2025-08-28 17:27
 */
public class StrStr {

    /**
     * 朴素解法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int h = haystack.length(), n = needle.length();
        int l = 0, r = 0;
        for (int i = 0; i <= h - n; i++) {
            l = i;
            while (r < n && haystack.charAt(l) == needle.charAt(r)) {
                l++;
                r++;
                if (r == n) {
                    return i;
                }
            }
            r = 0;
        }
        return -1;
    }

    public int strStrTwo(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        char[] hh = haystack.toCharArray();
        char[] nn = needle.toCharArray();
        int[] next = kmp(hh);
        int j = 0;
        for (int i = 0; i < h; i++) {
            while (j > 0 && hh[i] != nn[j]) {
                j = next[j - 1];
            }
            if (hh[i] == nn[j]) {
                j++;
                if (j == n) {
                    return i-n+1;
                }
            }
        }
        return -1;
    }

    int[] kmp(char[] ch) {
        int[] next = new int[ch.length];
        int j = 0;
        for (int i = 1; i < ch.length; i++) {
            while (j > 0 && ch[i] != ch[j]) {
                j = next[j - 1];
            }
            if (ch[i] == ch[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * kmp
     *
     * @param args
     */
    public static void main(String[] args) {
        String a = "mississipa", b = "issip";
        StrStr st = new StrStr();
        System.out.println(st.strStrTwo(a, b));
    }

}

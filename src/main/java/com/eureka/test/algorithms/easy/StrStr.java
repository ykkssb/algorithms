package com.eureka.test.algorithms.easy;

/**
 * <p>实现strStr（）</p>
 * https://leetcode-cn.com/problems/implement-strstr/solution/zhe-ke-neng-shi-quan-wang-zui-xi-de-kmp-8zl57/
 * https://www.bilibili.com/video/av3246487?from=search&seid=2688728712457575436
 * https://www.bilibili.com/video/BV1iJ411u74L/?spm_id_from=333.788.recommend_more_video.0
 *
 * @Author : Eric
 * @Date: 2020-03-26 19:15
 */
public class StrStr {

    /**
     * 方法一：子串逐一比较 - 线性时间复杂度
     * 时间复杂度：O((N - L)L)
     * 空间复杂度：O(1)
     * strStr
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int L = haystack.length(), R = needle.length();
        if (R > L) {
            return -1;
        } else if (L == 0 || R == 0) {
            return 0;
        }
        // aaaab
        // ab
        int l = 0, r = 0;
        while (l < L && r < R) {
            if (haystack.charAt(l) == needle.charAt(r)) {
                r++;
            } else if (r > 0) {
                l -= r;
                r = 0;
            }
            l++;
        }
        if (r == R) {
            return l - R;
        }

        return -1;

    }


    /**
     * KMP SubString Search
     * https://www.bilibili.com/video/av3246487?from=search&seid=2688728712457575436
     * // TODO: 2021-03-20
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrTwo(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        return kmp(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }

    // bcbcbcbcbea
    // bcbcbea
    // 0012300
    private int kmp(char[] lc, int l, char[] rc, int r) {
        int[] next = next(rc, r);
        int j = 0;
        for (int i = 0; i < l; i++) {


            while (j != 0 && lc[i] != rc[j]) {
                j = next[j - 1];
                if (i - j + r > l) {
                    return -1;
                }
            }
            if (lc[i] == rc[j]) {
                j++;
            }
            if (j == r) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //  aabaabaaa
    //  010123452
    public int[] next(char[] needle, int r) {

        int[] next = new int[r];
        next[0] = 0;
        int k = next[0];
        for (int i = 1; i < r; i++) {

            while (k != 0 && needle[k] != needle[i]) {
                k = next[k - 1];
            }

            if (needle[k] == needle[i]) {
                k++;
            }

            next[i] = k;
        }
        return next;
    }


    public static void main(String[] args) {

        StrStr st = new StrStr();
        String l = "bcbcbcbcbea";
        String n = "bcbcbea";
//        String n = "aabaabaaa";
//        System.out.println(st.next(n.toCharArray(), n.length()));
        System.out.println(st.strStrTwo(l, n));
    }
}

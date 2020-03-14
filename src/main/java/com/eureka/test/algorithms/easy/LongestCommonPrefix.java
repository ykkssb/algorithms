package com.eureka.test.algorithms.easy;

/**
 * <p>最长公共前缀</p>
 * <p>
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
 *
 * @Author : Eric
 * @Date: 2020-03-14 16:59
 */
public class LongestCommonPrefix {
    /**
     * 水平查找法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.length() == 0) {
                    return "";
                }
            }
        }
        return pre;
    }

    /**
     * 水平扫描法
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefixTwo(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];

        int n = strs.length;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) != c && strs[j].length() >= i) {
                    str = str.substring(0, i);
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixTwo(strs));
    }
}

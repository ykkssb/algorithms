package com.eureka.test.algorithms.hard;

import java.util.*;

/**
 * <p>最小覆盖子串
 * 滑动窗口
 * </p>
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-suan-fa-tong-yong-si-xiang-by-/
 *
 * @Author : Eric
 * @Date: 2020-06-04 18:05
 */
public class MinWindow {
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {

        int l = 0, r = 0;
        int maxLen = 0;
        int start = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            // s:aa ,t:aa
            ori.put(t.charAt(i),
                    ori.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (r < s.length()) {
            char t1 = s.charAt(r);
            if (ori.containsKey(t1)) {
                cnt.put(t1, cnt.getOrDefault(t1, 0) + 1);
                // == 最后测试用例过不去
                if (cnt.get(t1).equals(ori.get(t1))) {
                    maxLen++;
                }
            }
            r++;

            // 不是t.length ex:重复字符串 aab, aa maxLen =1
            while (maxLen == cnt.size()) {

                char t2 = s.charAt(l);
                if (r - l < len) {
                    start = l;
                    len = r - l;
                }
                // aeabc  ,abc
                if (cnt.containsKey(t2)) {


                    if (cnt.get(t2).equals(ori.get(t2))) {
                        maxLen--;
                    }
                    cnt.put(t2, cnt.getOrDefault(t2,0)-1);
                }
                l++;
            }
        }

        // a,a 测试用例
        return s.length() == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "aab";
        String t = "aa";

        MinWindow m = new MinWindow();
        System.out.println(m.minWindow(s, t));
    }
}

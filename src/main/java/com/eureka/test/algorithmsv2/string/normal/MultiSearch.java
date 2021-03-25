package com.eureka.test.algorithmsv2.string.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>面试题 17.17. 多次搜索 </p>
 * https://leetcode-cn.com/problems/multi-search-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-20 20:16
 */
public class MultiSearch {

    /**
     * 解法一 KMP算法
     * todo
     * aaaa相同字符匹配
     */
    public int[][] multiSearch(String big, String[] smalls) {
        int l = big.length(), r = smalls.length;
        if (l == 0 || r == 0) {
            return new int[r][0];
        }
        char[] cl = big.toCharArray();
        int[][] rs = new int[r][];

        for (int i = 0; i < smalls.length; i++) {
            char[] s = smalls[i].toCharArray();
            rs[i] = transfer(kmp(cl, l, s, s.length));
        }
        return rs;
    }

    // aaaaaaaa...
    // aa
    public List<Integer> kmp(char[] cl, int l, char[] cr, int r) {
        if (l == 0 || r == 0 || l < r) {
            return new ArrayList<>();
        }
//        int[] res = new int[l];
        List<Integer> list = new ArrayList<>();
        int[] next = next(cr, r);
        int j = 0;
        int len = 0;
        for (int i = 0; i < l; i++) {
            while (j != 0 && cl[i] != cr[j]) {
                j = next[j - 1];
                if (i - j + r > l) {
                    return list;
                }
            }

            if (cl[i] == cr[j]) {
                j++;
                if (j == r) {
                    list.add(i - j + 1);
                    j = next[j - 1];
                }
            }
        }
        return list;
    }

    public int[] next(char[] pat, int l) {
        int[] next = new int[l];
        next[0] = 0;
        int k = 0;
        for (int i = 1; i < l; i++) {

            while (k != 0 && pat[k] != pat[i]) {
                k = next[k - 1];
            }
            if (pat[k] == pat[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    private int[] transfer(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MultiSearch m = new MultiSearch();
//        String n = "aa";tqxgnorygrzthdjvfffalen
//        System.out.println(m.next(n.toCharArray(), n.length()));
//        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
//        System.out.println(m.multiSearch("mississippi", smalls));
//        String[] smalls = { "ff"};
//        System.out.println(m.multiSearch("tqxgnorygrzthdjvfffa", smalls));
        String[] smalls = {"a", "aa", "aaa"};
        System.out.println(m.multiSearch("aaaaaaaaaaaaaaaaaaaaaaaa", smalls));
    }
}

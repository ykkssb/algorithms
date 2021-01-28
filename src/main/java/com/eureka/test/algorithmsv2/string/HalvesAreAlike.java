package com.eureka.test.algorithmsv2.string;

import java.util.Arrays;
import java.util.List;

/**
 * <p>1704. 判断字符串的两半是否相似</p>
 * https://leetcode-cn.com/problems/determine-if-string-halves-are-alike/
 *
 * @Author : Eric
 * @Date: 2021-01-26 16:09
 */
public class HalvesAreAlike {
    List<Integer> y = Arrays.asList('a' - 'a', 'e' - 'a', 'i' - 'a', 'o' - 'a', 'u' - 'a',
            'A' - 'a', 'E' - 'a', 'I' - 'a', 'O' - 'a', 'U' - 'a');

    public boolean halvesAreAlike(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = 0;
        int halfIndex = ch.length / 2;
        for (int i = 0; i < ch.length; i++) {
            if (i < halfIndex) {

                if (y.contains(ch[i] - 'a')) {
                    l++;
                }
            } else {
                if (i == halfIndex && ch.length % 2 != 0) {
                    continue;
                }
                if (y.contains(ch[i] - 'a')) {
                    r++;
                }
            }
        }
        return l == r;
    }

    public static void main(String[] args) {
        HalvesAreAlike h = new HalvesAreAlike();
        System.out.println(h.halvesAreAlike("a"));

    }
}

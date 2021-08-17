package com.eureka.test.algorithmsv2.string;

import java.util.List;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 *
 * @Author : Eric
 * @Date: 2021-03-20 20:08
 */
public class ReverseWords {
    /**
     * todo v2
     * 空字符串"" equals
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] list = s.split(" ");
        String res = "";
        for (int i = list.length - 1; i >= 0; --i) {
            if (!"".equals(list[i])) {
                res += list[i] + " ";
            }

        }
        if (res.length() > 0) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();

        System.out.println(rw.reverseWords("  hello world!  "));
    }
}

package com.eureka.test.algorithmsv2.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>696. 计数二进制子串 </p>
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * @Author : Eric
 * @Date: 2021-02-20 14:38
 */
public class CountBinarySubstrings {

    /**
     * 方法一：按字符分组
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {

        int res = 0;
        List<Integer> list = new ArrayList<>();

        int l = 0;
        char[] ch = s.toCharArray();

        while (l < s.length()) {

            char c = ch[l];
            int count = 0;
            while (l < s.length() && c == ch[l]) {
                count++;
                l++;
            }
            list.add(count);
        }


        for (int i = 1; i < list.size(); i++) {
            res += Math.min(list.get(i - 1), list.get(i));
        }
        return res;
    }

    public int countBinarySubstringsTwo(String s) {
        char[] ch = s.toCharArray();
        int len = 0, res = 0;
        int l = 0, r = 0;
        while (len < s.length()) {
            char c = ch[len];
            while (len < s.length() && c == ch[len]) {
                r++;
                len++;
            }
            res += Math.min(l, r);
            l = r;
            r = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings c = new CountBinarySubstrings();
        System.out.println(c.countBinarySubstringsTwo("001100"));
    }
}


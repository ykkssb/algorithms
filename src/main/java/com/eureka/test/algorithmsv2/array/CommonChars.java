package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>1002. 查找常用字符</p>
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @Author : Eric
 * @Date: 2021-03-28 02:32
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        int[] ma = new int[26];
        Arrays.fill(ma, Integer.MAX_VALUE);
        for (String a : A) {
            int[] n = new int[26];
            int length = a.length();
            for (int i = 0; i < length; ++i) {
                char ch = a.charAt(i);
                n[ch - 'a']++;
            }

            for (int i = 0; i < 26; ++i) {
                ma[i] = Math.min(n[i], ma[i]);
            }
        }

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < ma[i]; ++j) {
                list.add(String.valueOf((char) ('a' + i)));
            }
        }
        return list;

    }

    public static void main(String[] args) {
        CommonChars cc = new CommonChars();
        String[] c = {"bella", "label", "roller"};
        System.out.println(cc.commonChars(c));
    }
}

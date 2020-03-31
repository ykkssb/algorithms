package com.eureka.test.algorithms.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>串联所有单词的子串</p>
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * @Author : Eric
 * @Date: 2020-03-28 15:12
 */
public class FindSubstring {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return ans;
        }
        int num = words[0].length();
        int len = words.length;
        int total = num * len;
        Map<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < s.length() - total + 1; i++) {
            String a = s.substring(i, i + total);
            Map<String, Integer> p = new HashMap<>();
            for (int j = 0; j < total - num + 1; j += num) {
                String sb = a.substring(j, j + num);
                p.put(sb, p.getOrDefault(sb, 0) + 1);
            }

            if (map.equals(p)) {
                ans.add(i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "abcedfaweabcedf";
        String[] words = {"abc", "edf"};
        System.out.println(findSubstring(s, words));

    }
}


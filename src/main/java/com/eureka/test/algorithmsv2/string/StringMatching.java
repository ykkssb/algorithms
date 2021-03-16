package com.eureka.test.algorithmsv2.string;

import java.util.*;

/**
 * <p>1408. 数组中的字符串匹配</p>
 * https://leetcode-cn.com/problems/string-matching-in-an-array/
 *
 * @Author : Eric
 * @Date: 2021-02-20 16:32
 */
public class StringMatching {
    public List<String> stringMatching(String[] words) {
        Set<String> res = new HashSet<>();
        Arrays.sort(words, (String a, String b) -> b.length() - a.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length; j++) {
                if (words[i].contains(words[j]) && !words[i].equals(words[j])) {
                    res.add(words[j]);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        StringMatching s = new StringMatching();
        String[] words = {"leetcode","et","code"};
        System.out.println(s.stringMatching(words));
    }
}

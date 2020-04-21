package com.eureka.test.algorithms.normal;

import java.util.*;

/**
 * <p>字母异位词分组</p>
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @Author : Eric
 * @Date: 2020-04-17 17:34
 */
public class GroupAnagrams {

    /**
     * 方法一：排序数组分类
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        int n = strs.length;
        for (int i = 0; i < n; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);

            String tmp = String.valueOf(c);
            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * 方法二：按计数分类
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsTwo(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);

            char[] cha = str.toCharArray();
            for (char c : cha) {
                count[c - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }

            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagramsTwo(s));
    }
}
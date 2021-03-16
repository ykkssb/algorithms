package com.eureka.test.algorithmsv2.string.normal;

import java.util.*;

/**
 * <p>面试题 10.02. 变位词组 </p>
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-02 17:55
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String ne = new String(c);
            if (!map.containsKey(ne)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(ne, list);
            } else {
                List<String> list = map.get(ne);
                list.add(str);
            }
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(str));
    }
}

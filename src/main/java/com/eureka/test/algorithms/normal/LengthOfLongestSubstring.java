package com.eureka.test.algorithms.normal;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * <p>无重复字符的最长子串</p>
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author : Eric
 * @Date: 2020-03-06 20:05
 */
public class LengthOfLongestSubstring {

    /**
     * 暴力法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(min(n, m))
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        // Set用String contains比较也要用String类型否则比较结果false，
        // 建议直接用Character类型
        Set<String> set = Sets.newHashSet();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if (set.contains(String.valueOf(c))) {
                return false;
            } else {
                set.add(String.valueOf(c));
            }
        }
        return true;
    }

    /**
     * 滑动窗口
     * <p>
     * 在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 i 到 j - 1之间的子字符串
     * 已经被检查为没有重复字符。我们只需要检查 s[j]对应的字符是否已经存在于子字符串中。
     * 要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2) 的算法
     * <p>
     * 时间复杂度：O(2n) = O(n)
     * 空间复杂度：O(min(m, n))
     *
     * @param s
     */
    public static int lengthOfLongestSubstringTwo(String s) {
        Set<Character> set = Sets.newHashSet();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化滑动窗口
     * 如果 s[j] 在 [i, j) 范围内有与 j 重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j']范围内的所有元素，并将 i 变为 j' + 1
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringThree(String s) {
        Map<Character, Integer> map = Maps.newHashMap();
        Set<Character> set = Sets.newHashSet();
        int n = s.length();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            /**
             * else互斥导致bbbb这些长度为2
             * map 会将重复的字符下标V值覆盖
             */
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);

            if (n - i < ans) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "bbbbb";
        String s = "abcabgabc";
        System.out.println(lengthOfLongestSubstringThree(s));
//        System.out.println(lengthOfLongestSubstringTwo(s));

    }
}

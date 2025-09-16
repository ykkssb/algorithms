package com.eureka.test.algorithmsv2.tanxin;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-duplicate-letters/?envType=problem-list-v2&envId=greedy
 * <p>
 * 去除重复字母
 *
 * @author : yujie.wang
 * @date: 2025-09-16 18:04
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] z = new int[26];
        for (int i = 0; i < s.length(); i++) {
            z[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<Character>();
        boolean[] has = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int letter = c - 'a';
            z[letter]--;
            /**
             *  bbbbab 这样只有一个 b
             *  acdbc st里b<c 不会pop还是push进取 必须通过 has 数组过滤
             */
            if (has[letter]) {
                continue;
            }
            while (!st.isEmpty() && st.peek() > c) {
                // babc a<b 且 a 出现一次
                if (z[st.peek() - 'a'] == 0) {
                    break;
                }
                has[st.pop() - 'a'] = false;
            }
            st.push(c);
            has[letter] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        System.out.println(rdl.removeDuplicateLetters("cbacdcbc"));
    }
}

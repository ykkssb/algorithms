package com.eureka.test.algorithmsv2.bfs.hard;

import java.util.*;

/**
 * <p>127. 单词接龙 HARD</p>
 * https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
 *
 * @Author : Eric
 * @Date: 2021-07-15 18:30
 */
public class LadderLength {

    /**
     * todo
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }
        int n = 0;
        int index = wordList.indexOf(beginWord);
        boolean[] bo = new boolean[wordList.size() + 1];
        if (index >= 0)
            bo[index] = true;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int len = q.size();
            n++;
            while (len-- > 0) {
                String ma = q.poll();

                for (int i = 0; i < wordList.size(); i++) {
                    if (bo[i]) {
                        continue;
                    }
                    String s1 = wordList.get(i);
                    if (!match(ma, s1)) {
                        continue;
                    }
                    if (s1.equals(endWord)) {
                        return n + 1;
                    }
                    bo[i] = true;
                    q.offer(s1);
                }
            }
        }
        return 0;
    }


    public boolean match(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int dif = 0;
        for (int i = 0; i < c1.length; i++) {
            if (dif > 1) {
                return false;
            }
            if (c1[i] != c2[i]) {
                dif++;
            }
        }
        return dif == 1;
    }

    public static void main(String[] args) {
        LadderLength l = new LadderLength();
//        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        System.out.println(l.ladderLength("hit", "cog", list
        List<String> list = Arrays.asList("a", "b", "c");
        System.out.println(l.ladderLength("a", "c", list
        ));
    }
}

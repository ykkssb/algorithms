package com.eureka.test.algorithmsv2.bfs.hard;

import java.util.*;

/**
 * <p>126. 单词接龙 II</p>
 * https://leetcode-cn.com/problems/word-ladder-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-3
 *
 * @Author : Eric
 * @Date: 2021-07-16 18:38
 */
public class FindLadders {
    /**
     * todo very hard
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();

        boolean has = bfs(beginWord, endWord, distance, map, set);

        if (has) {
            Deque<String> q = new ArrayDeque<>();
            q.addFirst(endWord);
            dfs(beginWord, endWord, q, res, map);
        }
        return res;
    }

    public boolean bfs(String st, String end, Map<String, Integer> distance, Map<String, Set<String>> map,
                       Set<String> set) {
        boolean has = false;

        Queue<String> q = new LinkedList<>();
        q.offer(st);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            while (size > 0) {
                size--;
                String cur = q.poll();
                char[] chCur = cur.toCharArray();
                for (int i = 0; i < chCur.length; ++i) {
                    char begin = chCur[i];
                    for (char j = 'a'; j < 'z'; j++) {
                        chCur[i] = j;
                        String next = String.valueOf(chCur);
                        if (distance.containsKey(next) && distance.get(next) == step) {
                            map.get(next).add(cur);
                        }
                        if (!set.contains(next)) {
                            continue;
                        }

                        set.remove(next);
                        q.offer(next);
                        map.putIfAbsent(next, new HashSet<>());
                        map.get(next).add(cur);
                        distance.put(next, step);

                        if (next.equals(end)) {
                            has = true;
                        }
                    }
                    chCur[i] = begin;
                }
            }
            if (has) {
                break;
            }
        }
        return has;
    }

    public void dfs(String st, String cur, Deque<String> q, List<List<String>> res, Map<String, Set<String>> map) {
        if (cur.equals(st)) {
            res.add(new ArrayList<>(q));
            return;
        }
        for (String s : map.get(cur)) {
            q.addFirst(s);
            dfs(st, s, q, res, map);
            q.removeFirst();
        }
    }

    public static void main(String[] args) {
        FindLadders f = new FindLadders();
        List<String> list = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        System.out.println(f.findLadders("red", "tax", list));
    }
}

package com.eureka.test.algorithmsv2.topk;

import java.util.*;

/**
 * <p>692. 前K个高频单词</p>
 * https://leetcode-cn.com/problems/top-k-frequent-words/submissions/
 *
 * @Author : Eric
 * @Date: 2021-07-01 19:45
 */
public class TopKFrequentTw {

    /**
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(key);
        }
        Collections.sort(res,
                new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return map.get(a) == map.get(b) ?
                                a.compareTo(b)
                                : map.get(b) - map.get(a);

                    }
                });

        return res.subList(0, k);
    }

    /**
     * 方法二：优先队列 todo v2
     * 时间复杂度：O(l×n+m×l logk)
     * 空间复杂度：O(l×(m+k))
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequentTwo(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        return map.get(a) == map.get(b) ?
                                b.compareTo(a) : map.get(a) - map.get(b);
                    }
                }
        );
        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }

        Collections.reverse(res);

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentTw t = new TopKFrequentTw();
        String[] w = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        System.out.println(t.topKFrequentTwo(w, 4));
    }
}

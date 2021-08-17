package com.eureka.test.algorithmsv2.topk;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;

/**
 * <p>347. 前 K 个高频元素</p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @Author : Eric
 * @Date: 2021-06-30 15:33
 */
public class TopKFrequent {

    /**
     * 解法二：最小堆
     * 题目最终需要返回的是前 kk 个频率最大的元素，可以想到借助堆这种数据结构，对于 kk 频率之后的元素不用再去处理，进一步优化时间复杂度
     * todo v3
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                }
        );
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int[] res = new int[k];
        int l = 0;
        while (!pq.isEmpty()) {
            res[l++] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
//        int[] n = {1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 6};
        int[] n = {3,0,1,0};
        int k = 1;
        System.out.println(t.topKFrequent(n, k));
    }
}

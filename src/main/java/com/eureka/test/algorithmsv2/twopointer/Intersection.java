package com.eureka.test.algorithmsv2.twopointer;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * <p>349. 两个数组的交集</p>
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @Author : Eric
 * @Date: 2021-01-15 18:24
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, i);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && Objects.equals(map.get(i), i)) {
                map.put(i, i + 1);
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Intersection i = new Intersection();
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        Arrays.stream(i.intersection(nums1, nums2)).forEach(System.out::println);
    }
}

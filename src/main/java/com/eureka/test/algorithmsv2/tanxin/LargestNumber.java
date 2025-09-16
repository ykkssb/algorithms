package com.eureka.test.algorithmsv2.tanxin;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/largest-number/description/?envType=problem-list-v2&envId=greedy
 * <p>
 * 最大数
 *
 * @author : yujie.wang
 * @date: 2025-09-16 16:35
 */
public class LargestNumber {

    /**
     * 可使用编程语言的内置排序函数实现，需自定义判断规则。 学习点 Arrays.sort
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] st = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            st[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(st, (x, y) -> (y + x).compareTo(x + y));

        if (st[0].equals("0")) {

            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length; i++) {
            sb.append(st[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        int[] a = {0, 0};

        System.out.println(l.largestNumber(a));
    }
}

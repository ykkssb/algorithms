package com.eureka.test.algorithmsv2.tanxin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/remove-k-digits/
 * <p>
 * 移掉 K 位数字
 *
 * @author : yujie.wang
 * @date: 2025-09-16 17:05
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> s = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && k > 0 && num.charAt(i) < s.peekLast()) {
                s.pollLast();
                k--;
            }
            s.add(num.charAt(i));
        }

        // s=9 k=1
        for(int i=0;i<k;i++){
            s.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        // 10200  k=1 删除1 剩余0200
        boolean firstZero = true;

        while (!s.isEmpty()) {
            char c = s.poll();
            if (firstZero && c == '0') {
                continue;
            }
            firstZero = false;
            sb.append(c - '0');
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits rk = new RemoveKdigits();

        System.out.println(rk.removeKdigits("9", 1));
    }
}

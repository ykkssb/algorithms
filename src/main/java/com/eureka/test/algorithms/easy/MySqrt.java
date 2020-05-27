package com.eureka.test.algorithms.easy;

import com.sun.org.apache.regexp.internal.RE;

/**
 * <p>X的平方根</p>
 * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 *
 * @Author : Eric
 * @Date: 2020-05-25 20:02
 */
public class MySqrt {

    /**
     * 二分查找
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        if (x == 0) {
            return 0;
        }
        while (l <= r) {
            // 中间值
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt q = new MySqrt();

        System.out.println(q.mySqrt(4));
    }
}

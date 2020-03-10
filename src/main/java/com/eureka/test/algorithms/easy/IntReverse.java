package com.eureka.test.algorithms.easy;

import sun.jvm.hotspot.debugger.Page;

/**
 * <p>整数反转</p>
 *
 * @Author : Eric
 * @Date: 2020-03-10 14:43
 */
public class IntReverse {

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(log(x))
     * 空间复杂度：O(1)
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int pop;
        int ret = 0;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (Integer.MAX_VALUE / 10 < ret || (Integer.MAX_VALUE / 10 == x && pop == Integer.MAX_VALUE % 10)) {

                return 0;
            }
            if (Integer.MIN_VALUE > x || (Integer.MIN_VALUE / 10 == x && pop == Integer.MIN_VALUE % 10)) {
                return 0;
            }
            ret = pop + ret * 10;
        }

        return ret;
    }

    public static void main(String[] args) {
        int x = -2147483648;
//        System.out.println(1 / 10);
        System.out.println(reverse(x));
    }
}

package com.eureka.test.algorithms.normal;

/**
 * <p>两数相除</p>
 * https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @Author : Eric
 * @Date: 2020-03-27 19:36
 */
public class Divide {

    /**
     * 位运算
     * 被除数a, 除数b；
     * 被除数a减去1xb，若结果大于等于被除数的一半，则减去2xb，假设a减去nxb后小于a的一半；
     * 令被除数a=a-nxb，继续执行步骤2，直到a<
     *
     * @param a
     * @param b
     * @return
     */
    public static int divide(int a, int b) {
        boolean flag = a > 0 ^ b > 0;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;

        }
        int ans = 0;
        while (a <= b) {

            int tmpAns = -1;
            int tmpB = b;
            while (a <= tmpB << 1) {
                if (tmpB < Integer.MIN_VALUE >> 1) {
                    break;
                }
                tmpAns = tmpAns << 1;
                tmpB = tmpB << 1;
            }
            a = a - tmpB;
            ans += tmpAns;
        }


        if (!flag) {
            if (ans <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                ans = -ans;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 19, b = 3;
        System.out.println(divide(19, 3));
    }
}

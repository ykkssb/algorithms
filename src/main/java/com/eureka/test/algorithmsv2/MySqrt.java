package com.eureka.test.algorithmsv2;

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
    public long mySqrt(int x) {
        int l = 0, r = x, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public double mySqrtThr(int x) {
        if (x == 0) {
            return x;
        }
        double a = 1, b = 1;
        while (true) {
            a = a - (a * a * a - x) / (3 * a * a);
            if (Math.abs(a - b) < 1e-7) {
                break;
            }
            b = a;

        }
        return (int) a;
    }

    /**
     * 牛顿迭代法
     * todo v4
     *
     * @param x
     * @return
     */
    public int mySqrtTwo(int x) {
        if (x == 0) {
            return x;
        }
        double a = x, b = x;
        while (true) {
            a = (a + x / a) / 2;
            if (Math.abs(a - b) < 1e-7) {
                break;
            }
            b = a;
        }
        return (int) b;
    }


    public static void main(String[] args) {
        MySqrt q = new MySqrt();

        System.out.println(q.mySqrtThr(27));
        System.out.println(q.mySqrt(36));
//        System.out.println(q.mySqrt(2147395599));
    }
}

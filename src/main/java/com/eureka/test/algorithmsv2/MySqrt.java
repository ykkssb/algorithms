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
            if ((long) mid * mid >= x) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public double mySqrtThr(int x) {
        double a =1;
        double b = a - (a * a * a - x) / (3 * a * a);
        while(a-b>0.000000001|| a-b<-0.000000001){
            a =b;
            b = a - (a * a * a - x) / (3 * a * a);
        }
        return b;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public long mySqrtTwo(int x) {
        int a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return a;
    }


    public static void main(String[] args) {
        MySqrt q = new MySqrt();

//        System.out.println(q.mySqrtTwo(16));
        System.out.println(q.mySqrtThr(27));
    }
}

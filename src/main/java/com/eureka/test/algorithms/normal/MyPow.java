package com.eureka.test.algorithms.normal;

/**
 * <p>X的N次幂</p>
 *
 * @Author : Eric
 * @Date: 2020-04-20 17:39
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }


        double res = pass(x, N);

        return res;
    }

    public double pass(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double res = pass(x, n / 2);
        if (n % 2 == 0) {
            res = res * res;
        } else {
            res = res * res * x;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPow m = new MyPow();
        double x = 2;
        int n = 4;
        System.out.println(m.myPow(x, n));
    }
}

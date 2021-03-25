package com.eureka.test.util;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-03-22 22:06
 */
public class lifanggen {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(gen(4,2));

        Thread.sleep(2000);
    }

    public static double gen(double x, double y) {
        if (Math.abs(y * y * y - x) < 0.0000001) {
            return y;
        }
        return gen((x / y / y + 2 * y) / 3, x);
    }
}

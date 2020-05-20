package com.eureka.test.algorithms.easy;

import java.util.Arrays;

/**
 * <p>数组加一</p>
 *
 * @Author : Eric
 * @Date: 2020-05-20 19:32
 */
public class PlusOne {

    /**
     * 太麻烦
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else if (n > 1 && digits[i] == 9) {
                if (i != 0) {
                    digits[i] = 0;
                    int tmp = digits[i - 1] + 1;
                    if (tmp == 10) {
                        continue;
                    } else {
                        digits[i - 1] = tmp;
                        return digits;
                    }
                } else {
                    digits = new int[n + 1];
                    digits[0] = 1;
                    return digits;
                }
            } else {
                int[] res = new int[n + 1];
                res[0] = 1;
                res[1] = 0;
                return res;
            }
        }

        return digits;
    }


    /**
     * 优化
     *
     * @param digits
     * @return
     */
    public int[] plusOneT(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne one = new PlusOne();
        int[] aa = {9, 9, 9};
        System.out.println(Arrays.toString(one.plusOneT(aa)));
    }
}

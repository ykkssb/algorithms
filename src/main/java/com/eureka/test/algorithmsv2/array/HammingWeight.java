package com.eureka.test.algorithmsv2.array;

/**
 * <p>191. 位1的个数</p>
 * https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * @Author : Eric
 * @Date: 2021-03-22 23:19
 */
public class HammingWeight {

    /**
     * 方法一：循环检查二进制位
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }

    /**
     * 方法二：位运算优化
     *
     * @param n
     */
    public int hammingWeightTwo(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        System.out.println(h.hammingWeightTwo(11));
    }
}

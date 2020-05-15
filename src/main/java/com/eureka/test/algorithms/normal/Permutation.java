package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>第几个排列</p>
 * https://leetcode-cn.com/problems/permutation-sequence/
 *
 *@Author : Eric
 * @Date: 2020-05-08 19:30
 */
public class Permutation {

    /**
     * 阶乘
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }

        List<Integer> item = new ArrayList<>();
        List<Integer> nlist = new ArrayList<>();
        nlist.add(1);
        for (int i = 1; i <= n; i++) {
            item.add(i);
            nlist.add(nlist.get(i - 1) * i);
        }

        StringBuffer sb = new StringBuffer();
        n = n - 1;
        k = k - 1;
        while (n >= 0) {

            if (n == 0) {
                sb.append(item.get(0));
                break;
            }

            int tmp = nlist.get(n);
            int index = k / tmp;

            sb.append(item.get(index));
            item.remove(index);
            n--;
            k = k % tmp;


        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.getPermutation(3, 2));

    }
}

package com.eureka.test.algorithmsv2.string;

import java.util.Arrays;

/**
 * <p>1128. 等价多米诺骨牌对的数量</p>
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 *
 * @Author : Eric
 * @Date: 2021-01-26 17:02
 */
public class NumEquivDominoPairs {
    /**
     * 二元组
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] n = new int[100];
        int res = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] l = dominoes[i];
            int val = l[0] < l[1] ? l[0] * 10 + l[1] : l[0] + l[1] * 10;
            res += n[val];
            n[val]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] n = {{1, 2}, {2, 1}, {3, 4}, {2, 1}};
        System.out.println(n.length);
        NumEquivDominoPairs ne = new NumEquivDominoPairs();
        System.out.println(ne.numEquivDominoPairs(n));

    }
}

package com.eureka.test.algorithmsv2.dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solutions/552695/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
 * 买卖股票的最佳时机 III
 * <p>
 * todo v1 动态规划
 *
 * @author : yujie.wang
 * @date: 2025-08-27 16:46
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int b1 = -prices[0], s1 = 0;
        int b2 = -prices[0], s2 = 0;
        for (int i = 0; i < len; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, b1 + prices[i]);
            // s1是7-1=6  b2=6-2 =4
            // 利润6+9-2 前利润减去后买入的
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, b2 + prices[i]);
        }

        return s2;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 2, 5, 7, 2, 3, 9};
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(a));
    }
}

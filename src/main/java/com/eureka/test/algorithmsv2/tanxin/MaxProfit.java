package com.eureka.test.algorithmsv2.tanxin;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 买卖股票的最佳时机 II
 *
 * @author : yujie.wang
 * @date: 2025-09-16 19:00
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int win = 0;
        int buy = prices[0];
        for (int i = 1; i < n; i++) {
            // 今天小于昨天
            if (prices[i] < prices[i - 1]) {
                win += prices[i - 1] - buy;
                buy = prices[i];
            } else {
                buy = Math.min(buy, prices[i]);
            }
        }
        return win+ prices[n-1]-buy;
    }

    public static void main(String[] args) {
        MaxProfit mx = new MaxProfit();
        int[] p = {6, 1, 3, 2, 4, 7};
        System.out.println(mx.maxProfit(p));
    }
}

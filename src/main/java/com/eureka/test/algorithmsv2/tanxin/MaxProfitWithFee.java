package com.eureka.test.algorithmsv2.tanxin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yujie.wang
 * @date: 2025-09-16 19:18
 */
public class MaxProfitWithFee {


    /**
     * 贪心思想可以浓缩成一句话，即当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
     * 在遍历完整个数组 prices 之后之后，我们就得到了最大的总收益
     */
    public int maxProfit(int[] prices, int fee) {
        int win = 0, n = prices.length;
        int buy = prices[0]+fee;
        for (int i = 0; i < n; i++) {
          if(buy<prices[i]){
              win += prices[i]-buy;
              buy = prices[i];
          }else if(prices[i]+fee< buy){
              buy = prices[i] +fee;
          }
        }
        return win ;
    }

    public static void main(String[] args) {
        MaxProfitWithFee mx = new MaxProfitWithFee();
        int[] p = {1, 3, 2, 8, 4, 9};
        System.out.println(mx.maxProfit(p, 2));
    }

}

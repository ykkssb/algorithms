package com.eureka.test.algorithmsv2.dp.medium;

import java.util.Arrays;
import org.elasticsearch.common.recycler.Recycler.C;

/**
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/
 * <p>
 * 2466. 统计构造好字符串的方案数
 *
 * @author : yujie.wang
 * @date: 2025-09-30 16:41
 */
public class CountGoodStrings {


    private static final int MOD = 1_000_000_007;

    /**
     * 爬楼梯晋升版本
     *
     * @param low  楼梯第 low 到 high 个台阶
     * @param high
     * @param zero 一次出现zero个0 相当于爬楼梯的一次爬1步或者2布步
     * @param one  一次出现one个1 zero 和 one 代替的就是1步 or 2步
     */
    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] memo = new int[high + 1];
        Arrays.fill(memo, -1);
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(i, zero, one, memo)) % MOD;
        }
        return ans;
    }

    int dfs(int i, int zero, int one, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        // 要点 比如 i 一开始传的10 那么从1-2-10 全部计算出来
        return memo[i] = (dfs(i - zero, zero, one, memo) + dfs(i - one, zero, one, memo)) % MOD;
    }

    public static void main(String[] args) {
        int low = 3, high = 5, zero = 2, one = 1;

        CountGoodStrings cgs = new CountGoodStrings();
        System.out.println(cgs.countGoodStrings(low, high, zero, one));
    }
}

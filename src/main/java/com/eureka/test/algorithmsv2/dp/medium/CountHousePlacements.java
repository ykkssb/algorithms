package com.eureka.test.algorithmsv2.dp.medium;

/**
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/description/
 * <p>
 * 统计放置房子的方式数
 *
 * @author : yujie.wang
 * @date: 2025-09-30 17:57
 */
public class CountHousePlacements {


    private static final int MOD = 1_000_000_007;
    /**
     * 1 <= n <= 104
     **/
    public static int[] dp = new int[10001];

    static {
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 10001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
    }

    /**
     * 若不放房子，那么第 i−1 个地块可放可不放，则有 f[i]=f[i−1]；
     * <p>
     * 若放房子，那么第 i−1 个地块无法放房子，第 i−2 个地块可放可不放，则有 f[i]=f[i−2]。 因此
     * <p>
     * f[i]=f[i−1]+f[i−2]
     */
    public int countHousePlacements(int n) {
        return (int) ((long) dp[n] * dp[n] % MOD);
    }
}

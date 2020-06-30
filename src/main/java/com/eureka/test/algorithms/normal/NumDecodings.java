package com.eureka.test.algorithms.normal;

/**
 * <p>解码方法</p>
 * https://leetcode-cn.com/problems/decode-ways/solution/java-jian-dan-dp-shi-jian-ji-bai-100-by-jiafeilee/
 *
 * @Author : Eric
 * @Date: 2020-06-24 15:42
 */
public class NumDecodings {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int n = s.length();
        char[] ch = s.toCharArray();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            if (ch[i] == '0') {
                continue;
            }
            int num = 0;
            for (int j = i; j < n && j - i < 2; j++) {
                num = num * 10 + ch[j] - '0';
                if (num <= 26) {
                    dp[i] += dp[j + 1];
                }
            }
        }
        return dp[0];

    }


    public static void main(String[] args) {
        NumDecodings decodings = new NumDecodings();
        System.out.println(decodings.numDecodings("126"));


    }

}

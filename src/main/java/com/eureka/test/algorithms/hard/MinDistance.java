package com.eureka.test.algorithms.hard;

/**
 * <p>编辑距离</p>
 * <p>
 * https://leetcode-cn.com/problems/edit-distance/solution/edit-distance-by-ikaruga/
 *
 * @Author : Eric
 * @Date: 2020-05-28 18:58
 */
public class MinDistance {

    /**
     * 方法一：动态规划
     * 编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
     * <p>
     * 最直观的方法是暴力检查所有可能的编辑方法，取最短的一个。所有可能的编辑方法达到指数级，但我们不需要进行这么多计算，因为我们只需要找到距离最短的序列而不是所有可能的序列。
     * <p>
     *
     * 31. 增，dp[i][j] = dp[i][j - 1] + 1
     * 32. 删，dp[i][j] = dp[i - 1][j] + 1
     * 33. 改，dp[i][j] = dp[i - 1][j - 1] + 1
     * 34. 按顺序计算，当计算 dp[i][j] 时，dp[i - 1][j] ， dp[i][j - 1] ， dp[i - 1][j - 1] 均已经确定了
     * 35. 配合增删改这三种操作，需要对应的 dp 把操作次数加一，取三种的最小
     * 36. 如果刚好这两个字母相同 word1[i - 1] = word2[j - 1] ，那么可以直接参考 dp[i - 1][j - 1] ，操作不用加一
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        if (n == 0 || m == 0) {
            return n + m;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int a = dp[j][i - 1] + 1;
                int b = dp[j - 1][i] + 1;
                int c = dp[j - 1][i - 1];
                if (word1.charAt(j - 1) != word2.charAt(i - 1)) {
                    c += 1;
                }
                dp[j][i] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        MinDistance s = new MinDistance();
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(s.minDistance(s1, s2));


    }

}

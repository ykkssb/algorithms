package com.eureka.test.algorithms.normal;

/**
 * <p>96. 不同的二叉搜索树</p>
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/shua-ti-chao-da-an-mian-shi-huan-shi-zuo-bu-chu-la/
 *
 * @Author : Eric
 * @Date: 2020-07-08 19:32
 */
public class NumGenerateTrees {

    /**
     * G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
     * <p>
     * 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
     * f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
     * <p>
     * 综合两个公式可以得到 卡特兰数 公式
     * G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumGenerateTrees g = new NumGenerateTrees();

        System.out.println(g.numTrees(4));
    }
}

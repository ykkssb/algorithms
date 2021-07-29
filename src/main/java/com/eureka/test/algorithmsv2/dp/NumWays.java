package com.eureka.test.algorithmsv2.dp;

/**
 * <p>1269. 停在原地的方案数</p>
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/solution/shu-ju-jie-gou-he-suan-fa-di-gui-ge-dong-glyo/
 *
 * @Author : Eric
 * @Date: 2021-07-13 10:31
 */
public class NumWays {
    private int mod = 1_00_000_000_7;

    /**
     * todo
     * 二维数组优化一维数组
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {
        int index = Math.min(steps / 2, arrLen - 1);
        long[] arr = new long[index + 1];
        arr[0] = 1;
        for (int i = 1; i <= steps; i++) {
            long last = 0;
            for (int j = 0; j <= index; j++) {
                long tmp = arr[j];
                if (j < index) {
                    arr[j] += arr[j + 1];
                }
                if (j > 0) {
                    arr[j] += last;
                }
                arr[j] %= mod;
                last = tmp;
            }
        }
        return (int) arr[0];
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][2];
        NumWays n = new NumWays();
        System.out.println(n.numWays(3, 2));

    }
}

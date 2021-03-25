package com.eureka.test.algorithmsv2.array;

/**
 * <p>1512. 好数对的数目</p>
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 *
 * @Author : Eric
 * @Date: 2021-03-22 23:50
 */
public class NumIdenticalPairs {

    /**
     * 方法二：组合计数
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
        int[] t = new int[100];
        int res = 0;
        for (int n : nums) {
            res += t[n - 1]++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumIdenticalPairs m = new NumIdenticalPairs();
        int[] n = {1,2,3,1,1,3};
        System.out.println(m.numIdenticalPairs(n));
    }
}

package com.eureka.test.algorithmsv2.array.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>421. 数组中两个数的最大异或值</p>
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 *
 * @Author : Eric
 * @Date: 2021-08-17 18:12
 */
public class FindMaximumXOR {

    /**
     * todo v3
     * 贪心算法
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; --i) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for(int n :nums){
                set.add(mask & n);
            }

            int tmp = res | 1 << i;
            for(Integer se: set){
                if (set.contains(se ^ tmp)) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMaximumXOR m = new FindMaximumXOR();
        int[] n = {3, 10, 5, 25, 2, 8};
        System.out.println(m.findMaximumXOR(n));

        Integer.valueOf("1");


    }
}

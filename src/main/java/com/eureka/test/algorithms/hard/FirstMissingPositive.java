package com.eureka.test.algorithms.hard;

/**
 * <p>缺失的第一个正数</p>
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @Author : Eric
 * @Date: 2020-04-09 20:14
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int res = 0;
        int tmp = 0;
        int n = nums.length - 1;

        while (res <= n) {
            if (nums[res] == res + 1) {
                res++;
            } else {
                tmp = nums[res];
                if (tmp > n + 1 || tmp < res + 1 || nums[tmp - 1] == tmp) {
                    nums[res] = nums[n--];
                } else {
                    nums[res] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive p = new FirstMissingPositive();

//        int[] n = {8, 9, 2, 5, 1, 2};
//        int[] n = {1, 2, 0};
//        int[] n = {2, 1};
        int[] n = {0};
        System.out.println(p.firstMissingPositive(n));
    }

}

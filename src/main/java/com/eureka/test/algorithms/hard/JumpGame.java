package com.eureka.test.algorithms.hard;

/**
 * <p>跳跃游戏</p>
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @Author : Eric
 * @Date: 2020-04-14 17:14
 */
public class JumpGame {

    public int jump(int[] nums) {
        int step = 0;
        int max = 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max, nums[i] + i);

            if (i == endIndex) {
                endIndex = max;
                step++;
            }
        }

        return step;
    }

    public static void main(String[] args) {
        int[] n = {2, 3, 1, 1, 4};
//        int[] n = {2, 3, 1, 1, 4, 2, 1};
        JumpGame j = new JumpGame();
        System.out.println(j.jump(n));
    }
}

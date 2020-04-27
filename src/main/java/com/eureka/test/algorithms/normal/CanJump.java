package com.eureka.test.algorithms.normal;

import com.eureka.test.algorithms.hard.JumpGame;

/**
 * <p>跳跃游戏</p>
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @Author : Eric
 * @Date: 2020-04-27 19:30
 */
public class CanJump {


    public boolean jump(int[] nums) {
        int len = nums.length;
        boolean res = false;
        int index = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == index) {
                index = max;
            }

        }
        if (index >= len - 1) {
            res = true;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 2, 0, 4};
        //        int[] n = {2, 3, 1, 1, 4, 2, 1};
        CanJump j = new CanJump();
        System.out.println(j.jump(n));
    }
}

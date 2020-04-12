package com.eureka.test.algorithms.hard;

import java.util.Stack;

/**
 * <p>接雨水</p>
 *
 * @Author : Eric
 * @Date: 2020-04-10 19:19
 */
public class TrapRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[index]) {

                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int cur = stack.peek();

                    res += (Math.min(height[i], height[cur]) - height[index]) * (i - cur - 1);
                }
            }
            stack.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] n = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] n = {2, 1, 0, 2};
        TrapRainWater t = new TrapRainWater();
        System.out.println(t.trap(n));

    }
}
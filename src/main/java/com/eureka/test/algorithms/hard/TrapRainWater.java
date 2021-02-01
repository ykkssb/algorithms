package com.eureka.test.algorithms.hard;

import java.util.Stack;

/**
 * <p>接雨水</p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @Author : Eric
 * @Date: 2020-04-10 19:19
 */
public class TrapRainWater {
    /**
     * todo 接雨水
     * 解法二：按列求
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 解法四：双指针
     *
     * @param height
     * @return
     */
    public int trapTwo(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        int l = 0, r = height.length - 1, maxL = 0, maxR = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > maxL) {
                    maxL = height[l];
                } else {
                    res += maxL - height[l];
                }
                l++;

            } else {
                if (height[r] > maxR) {
                    maxR = height[r];
                } else {
                    res += maxR - height[r];

                }
                r--;
            }
        }
        return res;
    }

    /**
     * 栈
     *
     * @param height
     * @return
     */
    public int trapThree(int[] height) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {

            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int r = st.peek();
                st.pop();
                if (st.isEmpty()) {
                    break;
                }
                int l = st.peek();
                int dis = i - l - 1;
                int hei = Math.min(height[i], height[l]);
                res += (hei - height[r]) * dis;
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] n = {4, 2, 0, 3, 2, 5};
        TrapRainWater t = new TrapRainWater();
        System.out.println(t.trapThree(n));

    }
}
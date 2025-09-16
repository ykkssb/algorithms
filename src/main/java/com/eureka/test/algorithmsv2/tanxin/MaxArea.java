package com.eureka.test.algorithmsv2.tanxin;

/**
 * https://leetcode.cn/problems/container-with-most-water/?envType=problem-list-v2&envId=greedy
 * <p>
 * 盛最多水的容器
 *
 * @author : yujie.wang
 * @date: 2025-09-16 16:43
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, (r - l) * (Math.min(height[l], height[r])));
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}

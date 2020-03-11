package com.eureka.test.algorithms.normal;

/**
 * <p>盛最多水的容器</p>
 *
 * @Author : Eric
 * @Date: 2020-03-11 18:24
 */
public class MaxArea {

    /**
     * 方法一：暴力法
     * 时间复杂度：O(n^2)
     * <p>
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, area(height, i, j));
            }
        }
        return max;
    }

    public static int area(int[] height, int i, int j) {
        return (j - i) * Math.min(height[i], height[j]);
    }

    /**
     * 方法二：双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    public static int maxAreaTwo(int[] height) {
        int n = height.length, l = 0, r = n - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxAreaTwo(a));
    }
}

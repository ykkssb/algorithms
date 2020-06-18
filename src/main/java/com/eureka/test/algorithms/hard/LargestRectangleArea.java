package com.eureka.test.algorithms.hard;

import java.util.Stack;

/**
 * <p>柱状图中最大的矩形</p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/ *
 *
 * @Author : Eric
 * @Date: 2020-06-16 19:41
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int res = 0;
        Stack<Integer> st = new Stack<>();

        /**
         * 数组一定要>2 ; 0,,,,,,,,0  :  {1}
         */
        int[] t = new int[n + 2];

        /**
         * 数组扩容，前后各加一位0
         */
        for (int j = 1; j <= n; j++) {
            t[j] = heights[j - 1];
        }

        for (int i = 0; i < t.length; i++) {
            while (!st.isEmpty() && t[st.peek()] > t[i]) {
                int cur = st.pop();
                // 6>2 最大6，rm 6 ; 5>2 最大10
                res = (Math.max(res, (t[cur]) * (i - 1 - st.peek())));

            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        int[] h = {1};
//        int[] h = {2, 1, 5, 6, 2, 3};
        System.out.println(l.largestRectangleArea(h));
    }

}

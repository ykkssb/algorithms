package com.eureka.test.algorithms.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * <p>合并区间</p>
 *
 * @Author : Eric
 * @Date: 2020-04-28 19:28
 */
public class MergeIndex {

    /**
     * 贪心算法
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));

        Stack<int[]> st = new Stack<>();
        st.push(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];

            int[] pek = st.peek();
            if (cur[0] < pek[1]) {
                pek[1] = Math.max(cur[1], pek[1]);
            } else {
                st.push(cur);
            }
        }
        return st.toArray(new int[st.size()][]);
    }

    public static void main(String[] args) {
        MergeIndex i = new MergeIndex();
        int[][] n = {{1, 3}, {2, 6}};
        System.out.println(i.merge(n));
    }

}

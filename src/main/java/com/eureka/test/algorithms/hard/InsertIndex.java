package com.eureka.test.algorithms.hard;

import com.eureka.test.algorithms.normal.MergeIndex;

import java.util.*;

/**
 * <p>插入区间</p>
 * https://leetcode-cn.com/problems/insert-interval/
 *
 * @Author : Eric
 * @Date: 2020-04-29 18:59
 */
public class InsertIndex {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || newInterval == null) {
            return intervals;
        }

        int len = intervals.length;

        int start = newInterval[0], end = newInterval[1];
        List<int[]> st = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < len; i++) {

            if (intervals[i][0] > end) {
                st.add(intervals[i]);

            } else if (intervals[i][1] < start) {
                st.add(intervals[i]);
                index++;
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        st.add(index, new int[]{start, end});

        return st.toArray(new int[st.size()][2]);
    }

    public static void main(String[] args) {
        InsertIndex i = new InsertIndex();
        int[][] n = {{1, 3}, {5, 7}};
        int[] m = {2, 4};

        int[][] tmp = i.insert(n, m);
        for (int[] a : tmp) {
            System.out.println(Arrays.toString(a));
        }

    }
}

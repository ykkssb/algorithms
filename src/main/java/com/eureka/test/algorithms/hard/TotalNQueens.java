package com.eureka.test.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>N皇后 II</p>
 * https://leetcode-cn.com/problems/n-queens-ii/
 *
 * @Author : Eric
 * @Date: 2020-04-22 19:26
 */
public class TotalNQueens {
    int count;
    int[] cols;

    int[] mains;
    int[] sec;
    int[] queens;
    int n;

    /**
     * 方法1：回溯
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {

        cols = new int[n];
        mains = new int[2 * n];
        sec = new int[2 * n];
        queens = new int[n];
        this.n = n;
        this.count = 0;

        solve(0);
        return count;
    }

    public void solve(int row) {

        if (row >= n) {
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isQueen(row, col)) {
                place(row, col);

                if (row == n - 1) {
                    count++;
                }
                solve(row + 1);
                remove(row, col);
            }
        }

    }

    public boolean isQueen(int row, int col) {
        int tmp = cols[col] + mains[row - col + n - 1] + sec[row + col];

        return tmp == 0;
    }

    public void place(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        mains[row - col + n - 1] = 1;
        sec[row + col] = 1;
    }

    public void remove(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        mains[row - col + n - 1] = 0;
        sec[row + col] = 0;
    }


    public static void main(String[] args) {
//        TotalNQueens t = new TotalNQueens();
//        System.out.println(t.totalNQueens(4));
        System.out.println(1|0);
    }
}

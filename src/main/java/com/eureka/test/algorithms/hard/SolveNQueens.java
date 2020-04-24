package com.eureka.test.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>解决皇后</p>
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @Author : Eric
 * @Date: 2020-04-21 19:30
 */
public class SolveNQueens {

    private List<List<String>> output = new ArrayList<>();

    // 用于标记是否被列方向的皇后被攻击
    int[] cols;
    // 用于标记是否被主对角线方向的皇后攻击
    int[] mains;
    // 用于标记是否被次对角线方向的皇后攻击
    int[] secondary;
    // 用于存储皇后放置的位置
    int[] queens;

    int n;

    /**
     * 回溯
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        mains = new int[2 * n];
        secondary = new int[2 * n];
        queens = new int[n];
        this.n = n;
        placeQueen(0);
        return output;

    }

    public void placeQueen(int row) {
        if (row >= n) {
            return;
        }

        for (int col = 0; col < n; col++) {
            if (hasQueen(row, col)) {
                place(row, col);

                if (row == n - 1) {
                    solve();
                }
                placeQueen(row + 1);
                remove(row, col);
            }
        }
    }

    public boolean hasQueen(int row, int col) {
        int tmp = cols[col] + mains[row - col + n - 1] + secondary[row + col];
        return tmp == 0;
    }

    public void place(int row, int col) {

        queens[row] = col;
        cols[col] = 1;
        mains[row - col + n - 1] = 1;
        secondary[row + col] = 1;
    }

    public void remove(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        mains[row - col + n - 1] = 0;
        secondary[row + col] = 0;
    }

    public void solve() {

        List<String> out = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queens[i];
            StringBuffer sb = new StringBuffer();


            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - 1 - col; j++) {
                sb.append(".");
            }
            out.add(sb.toString());
        }
        output.add(out);

    }

    public static void main(String[] args) {
        SolveNQueens s = new SolveNQueens();

        System.out.println(s.solveNQueens(4));
    }
}

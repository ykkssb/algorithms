package com.eureka.test.algorithmsv2.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>130. 被围绕的区域</p>
 * https://leetcode-cn.com/problems/surrounded-regions/
 *
 * @Author : Eric
 * @Date: 2021-07-14 20:48
 */
public class Solve {
    int n, m;

    /**
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'
     * dfs
     * @param board
     */
    public void solve(char[][] board) {

         n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean isF = i == 0 || j == 0 || i == n - 1 || j == m - 1;
                if (isF && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        System.out.printf("");
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'B';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        char c1 = 'a';
        char c2 = 'a';
        System.out.println(c1==c2);
        list.add("1");
        list.remove(0);
        List<String > l2 = new ArrayList<>(list);
        char[][] ch = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        Solve s = new Solve();
        s.solve(ch);
    }
}


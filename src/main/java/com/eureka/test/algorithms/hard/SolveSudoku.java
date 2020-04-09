package com.eureka.test.algorithms.hard;

/**
 * <p>解数独</p>
 * https://leetcode-cn.com/problems/sudoku-solver/solution/hui-su-fa-jie-shu-du-by-i_use_python/
 *
 * @Author : Eric
 * @Date: 2020-04-07 19:18
 */
public class SolveSudoku {


    public void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int n = board[row][col] - '0';
                if (n >= 1 && n <= 9) {
                    rowUsed[row][n] = true;
                    colUsed[col][n] = true;
                    boxUsed[row / 3][col / 3][n] = true;
                }
            }
        }

        reserve(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    public boolean reserve(char[][] board, boolean[][] rowUsed, boolean[][] colUsed,
                           boolean[][][] boxUsed, int row, int col) {
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for (int n = 1; n <= 9; n++) {
                boolean use = !(rowUsed[row][n] || colUsed[col][n] || boxUsed[row / 3][col / 3][n]);
                if (use) {
                    rowUsed[row][n] = true;
                    colUsed[col][n] = true;
                    boxUsed[row / 3][col / 3][n] = true;

                    board[row][col] = (char) ('0' + n);
                    if (reserve(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                        return true;
                    }
                    rowUsed[row][n] = false;
                    colUsed[col][n] = false;
                    boxUsed[row / 3][col / 3][n] = false;

                    board[row][col] = '.';

                }

            }
        } else {
            return reserve(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] ss = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SolveSudoku sudo = new SolveSudoku();
        sudo.solveSudoku(ss);
        System.out.println("123");
    }
}

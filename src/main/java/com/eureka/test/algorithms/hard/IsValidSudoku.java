package com.eureka.test.algorithms.hard;

/**
 * <p>是否数独</p>
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @Author : Eric
 * @Date: 2020-04-03 20:15
 */
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        int len = board.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index = (i / 3) * 3 + j / 3;
                    if (row[i][num] == 1) {
                        return false;
                    } else {
                        row[i][num] = 1;
                    }
                    if (col[i][num] == 1) {
                        return false;
                    } else {
                        col[i][num] = 1;
                    }
                    if (box[index][num] == 1) {
                        return false;
                    } else {
                        box[index][num] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] ss = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        System.out.println(isValidSudoku(ss));


    }
}

package com.eureka.test.algorithms.normal;

/**
 * <p>单词搜索</p>
 * https://leetcode-cn.com/problems/word-search/submissions/
 *
 * @Author : Eric
 * @Date: 2020-06-08 19:21
 */
public class WordExist {
    public boolean exist(char[][] board, String word) {
        boolean[][] done = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && visit(i, j, 0, board, word, done)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean visit(int i, int j, int index, char[][] board, String word, boolean[][] done) {
        if (index == word.length()) {
            return true;
        }

        //  done[i][j] == true  已验证字符串后退 i-1|| j-1
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)
                || done[i][j] == true) {
            return false;
        }
        done[i][j] = true;

        if (visit(i + 1, j, index + 1, board, word, done) ||
                visit(i - 1, j, index + 1, board, word, done) ||
                visit(i, j + 1, index + 1, board, word, done) ||
                visit(i, j - 1, index + 1, board, word, done)) {
            return true;
        }
        done[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        WordExist we = new WordExist();
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        String word = "ABCB";
        System.out.println(we.exist(board, word));
    }

}

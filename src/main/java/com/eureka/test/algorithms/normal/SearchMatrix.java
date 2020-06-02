package com.eureka.test.algorithms.normal;

/**
 * <p>搜索二维矩阵</p>
 * https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/
 *
 * @Author : Eric
 * @Date: 2020-06-01 18:20
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        if (row == 0 || col == 0) {
            return false;
        }
        if (matrix[row - 1][col - 1] < target) {
            return false;
        }
        boolean is = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }


        return is;
    }

    public static void main(String[] args) {
        SearchMatrix se = new SearchMatrix();

        int[][] mat = {};
        int target = 13;
        System.out.println(se.searchMatrix(mat, target));


    }
}

package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>矩阵置零</p>
 *
 * @Author : Eric
 * @Date: 2020-05-29 17:47
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean col_0_zero = false;

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                col_0_zero = true;
            }
            for (int j = 1; j < row; j++) {
                if (matrix[j][i] == 0) {
                    matrix[j][0] = 0;
                    matrix[0][i] = 0;
                }
            }
        }

        // 必须倒排序，否则第一列置为0就全部置0
        for (int i = col - 1; i >= 0; i--) {
            for (int j = row - 1; j >= 1; j--) {

                if (matrix[j][0] == 0 || matrix[0][i] == 0) {
                    matrix[j][i] = 0;
                }
            }
            if (col_0_zero) {
                matrix[0][i] = 0;
            }
        }


        // 二维数组sout
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        SetZeroes s = new SetZeroes();

//        int[][] a = new int[][]{{1, 0, 2}};
//        int[][] a = new int[][]{{1, 1, 1}, {0, 1, 2}};
        int[][] a = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
//
        s.setZeroes(a);
    }
}

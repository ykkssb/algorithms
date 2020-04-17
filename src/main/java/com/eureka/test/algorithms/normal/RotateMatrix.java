package com.eureka.test.algorithms.normal;

/**
 * <p>旋转矩阵</p>
 * https://leetcode-cn.com/problems/rotate-image/
 *
 * @Author : Eric
 * @Date: 2020-04-16 19:47
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int c = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
        System.out.println(11);
    }

    public static void main(String[] args) {
        RotateMatrix m = new RotateMatrix();
        int[][] n = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        m.rotate(n);
    }
}

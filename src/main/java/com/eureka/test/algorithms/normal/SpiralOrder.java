package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>旋转矩阵</p>
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @Author : Eric
 * @Date: 2020-04-24 19:10
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int count = (Math.min(row, col) + 1) / 2;
        int i = 0;

        while (i < count) {
            for (int j = i; j < col - i; j++) {
                res.add(matrix[i][j]);
            }

            for (int j = i + 1; j < row - i; j++) {
                res.add(matrix[j][col - 1 - i]);
            }
            //row - 1 - i 是指随着层数增加时，层数的边界所在行（即最上行和最下行的所处的行数），如果出现最上行和最下行是同一行的情况
            for (int j = col - 2 - i; j >= i && (row - 1 - i != i); j--) {
                res.add(matrix[row - 1 - i][j]);
            }
            for (int j = row - 2 - i; j > i && (col - 1 - i != i); j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
//        int[][] n = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] n = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] n = {{2}, {3}, {4}};
//        int[][] n = {{2, 3}};
        System.out.println(s.spiralOrder(n));
    }
}

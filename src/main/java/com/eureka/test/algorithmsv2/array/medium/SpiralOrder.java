package com.eureka.test.algorithmsv2.array.medium;

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

    /**
     * todo v2
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length, column =matrix[0].length;
        if(matrix==null||matrix.length==0){
            return res;
        }
        int l= 0, r=column-1 ,top=0, down = row-1;
        int count = row * column;

        while(res.size()<count){
            for(int i=l;i<=r; ++i){
                res.add(matrix[top][i]);
            }
            for(int i=top+1;i<=down; ++i){
                res.add(matrix[i][r]);
            }
            if(l<r && top<down){
                for(int i=r-1;i>l ;--i){
                    res.add(matrix[down][i]);
                }
                for(int i=down;i>top ;--i){
                    res.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            top++;
            down--;
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

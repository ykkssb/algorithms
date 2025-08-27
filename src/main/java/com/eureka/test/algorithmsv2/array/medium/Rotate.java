package com.eureka.test.algorithmsv2.array.medium;

/**
 * @author : yujie.wang
 * @date: 2025-08-27 16:26
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        int[][] ans = new int[l][l];
        for(int i =0;i<l;i++){
            int s = 0;
            for(int j=l-1;j>=0 ;j--){
                ans[i][s++]=matrix[j][0];
            }
        }
        for (int i = 0; i < ans.length; i++) {
            matrix[i] = ans[i].clone();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate ro = new Rotate();
        ro.rotate(a);


    }
}

package com.eureka.test.algorithmsv2.array;

/**
 * <p>832. 翻转图像</p>
 * https://leetcode-cn.com/problems/flipping-an-image/
 * @Author : Eric
 * @Date: 2021-03-25 23:59
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int l = image.length;
        for(int i =0; i<l;i++){
            for(int j =l-1;j>=(l/2);j--){
                int t = image[i][j];
                image[i][j] = reverse( image[i][l-1-j]);
                image[i][l-1-j] = reverse(t);
            }
        }
        return image;
    }

    public int reverse(int i){
        if(i==0){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        FlipAndInvertImage f = new FlipAndInvertImage();
        int[][] n = {{1,1,0},{1,0,1},{0,0,0}};

        System.out.println(f.flipAndInvertImage(n));
    }
}

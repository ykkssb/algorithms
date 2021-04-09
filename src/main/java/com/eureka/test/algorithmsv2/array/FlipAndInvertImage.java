package com.eureka.test.algorithmsv2.array;

/**
 * <p>832. 翻转图像</p>
 * https://leetcode-cn.com/problems/flipping-an-image/
 *
 * @Author : Eric
 * @Date: 2021-03-25 23:59
 */
public class FlipAndInvertImage {
    /**
     * todo v1
     *
     * @param image
     * @return
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        for (int i = 0; i < len; ++i) {
            int row = len % 2 == 0 ? len / 2 - 1 : len / 2;

            for (int j = 0; j <= row; ++j) {
                int t = image[i][j];
                image[i][j] = image[i][len-1-j]^1;
                image[i][len-1-j] = t^1;
            }
        }
        return image;
    }


    public static void main(String[] args) {
        FlipAndInvertImage f = new FlipAndInvertImage();
        int[][] n = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        System.out.println(f.flipAndInvertImage(n));
    }
}

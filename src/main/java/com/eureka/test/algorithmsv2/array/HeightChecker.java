package com.eureka.test.algorithmsv2.array;

/**
 * <p>1051. 高度检查器</p>
 * https://leetcode-cn.com/problems/height-checker/
 *
 * @Author : Eric
 * @Date: 2021-03-28 01:15
 */
public class HeightChecker {

    /**
     * todo
     * 桶排序
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] co = new int[101];
        for (int he : heights) {
            co[he]++;
        }

        int res = 0, ma = 0;
        for (int i = 0; i < co.length; i++) {
            while (co[i]-- > 0) {
                if (heights[ma++] != i) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
        int[] ss = {1, 1, 10, 2, 1, 3};
        System.out.println(hc.heightChecker(ss));
    }
}

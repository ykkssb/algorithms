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
     * todo v1
     * 桶排序
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] m = new int[101];
        int len = heights.length;
        int res = 0;
        for(int t:heights){
            m[t]++;
        }
        int index = 0;
        for(int i=0;i<m.length;++i){
            while(m[i]-->0){
                if(heights[index++]!=i){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;++i){
            System.out.println(i);
        }
        HeightChecker hc = new HeightChecker();
        int[] ss = {1, 1, 10, 2, 1, 3};
        System.out.println(hc.heightChecker(ss));
    }
}

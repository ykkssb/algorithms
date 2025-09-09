package com.eureka.test.algorithmsv2.string.hard;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/palindrome-partitioning-ii/description/
 * todo  非常难的推导公式
 *
 * @author : yujie.wang
 * @date: 2025-09-08 15:55
 */
public class MinCut {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] b = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            b[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i + 1) {
                        b[i][j] = true;
                    } else {
                        b[i][j] = b[i + 1][j - 1];
                    }
                }
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int j = 0; j < n; j++) {
            if (b[0][j]) {
                f[j] = 0;
            } else {
                for (int i = 0; i < j; ++i) {
                    if (b[i + 1][j]) {
                        f[j] = Math.min(f[j], f[i] + 1);
                    }
                }
            }
        }
        /**
         *         j + 1 到 i 这段不是回文的话，可以考虑这段所包含的每一个回文子串，
         *         设为 x 到 y 好了，那由于 x 到 y 是回文串，其必然已经在算 f(y) 的时候，
         *         被作为 f(x) + 1 考虑过，已经体现在了 f(y) 里；而我们知道单个字符都是回文子串
         *         所以 f(j) 一定可以由 f(y) 加上若干个回文子串扩展而来，
         *         假设扩展 k 次，那 f(j) 的值是一定体现了 f(y) + k 的这种情况的
         *         （当然是通过每次扩展完的右边界的 f 值来逐步体现的）。
         *         总结一下，也就是说不用单独考虑 j + 1 到 i 的非回文情况
         *         切割数加上 f(j) 构成一个更小切割的情况，只考虑 j + 1 到 i 的回文情况
         *         就足够了（已经包含了所有可能的最小切割数了）。
         */

//        int[] f = new int[n];
//        for(int j=0;j<n;j++){
//            if(b[0][j]){
//                f[j] = 0;
//            }else{
//                int res= Integer.MAX_VALUE;
//                for(int l=1;l<=j;l++){
//                    if(b[l][j]){
//                        res = Math.min(res, f[l-1]+1);
//                    }
//                }
//                f[j] = res;
//            }
//        }

        return f[n - 1];
    }

    public static void main(String[] args) {

        MinCut mc = new MinCut();
        System.out.println(mc.minCut("aaabaa"));
    }

}

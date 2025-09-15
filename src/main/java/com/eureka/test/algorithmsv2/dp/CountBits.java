package com.eureka.test.algorithmsv2.dp;

/**
 * https://leetcode.cn/problems/counting-bits/description/?envType=problem-list-v2&envId=dynamic-programming 比特位计数
 *
 * @author : yujie.wang
 * @date: 2025-09-13 16:31
 */
public class CountBits {

    /**
     * 汉明重量计算
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] f = new int[n+1];
        for(int i=0;i<=n;++i){
            f[i] = hanming(i);
        }
        return f;
    }

    public int hanming(int n){
        int ans = 0;
        while(n!=0){
            n &= (n-1);
            ans++;
        }
        return ans;
    }

    public int[] countBitsTwo(int n) {
        int[] f = new int[n+1];
        for(int i=1;i<n+1;++i){
            // 右移1位 +最低位和1 位运算
            f[i] = f[i>>1] + (i&1);
        }
        return f;
    }
}

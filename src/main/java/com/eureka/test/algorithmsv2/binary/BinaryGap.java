package com.eureka.test.algorithmsv2.binary;

/**
 *
 * https://leetcode.cn/problems/binary-gap/
 *
 * 二进制间距
 * @author : yujie.wang
 * @date: 2025-09-22 17:00
 */
public class BinaryGap {
    public int binaryGap(int n) {
        int idx =-1 ,ans=0;
        for(int i=0;i<32;i++)   {
            int t = ( n & 1) ==1 ? i:-1;
            n=n>>1;
            if(t!=-1){
                ans  = Math.max(ans,idx!=-1? t-idx:0);
                idx =t;
            }
        }
        return ans==0?0:ans;
    }

    public static void main(String[] args) {
        BinaryGap bg = new BinaryGap();
        //1101
        bg.binaryGap(13);
    }
}


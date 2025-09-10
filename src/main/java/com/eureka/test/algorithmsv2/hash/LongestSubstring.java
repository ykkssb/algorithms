package com.eureka.test.algorithmsv2.hash;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=problem-list-v2&envId=hash-table
 * 至少有 K 个重复字符的最长子串
 * @author : yujie.wang
 * @date: 2025-09-10 17:48
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k) {
        int ans =0;
        int n = s.length();
        int[] c = new int[26];
        for(int i=1;i<=26;i++){
            Arrays.fill(c, 0);
            int type= 0,num =0 ;
            int l = 0;
            for(int j=0;j<n;j++){
                int index = s.charAt(j)-'a';
                c[index]++;
                if(c[index]==1){
                    type++;
                }
                if(c[index]==k){
                    num++;
                }
                while(type>i){
                    int lindex= s.charAt(l++)- 'a';
                    c[lindex]--;
                    if(c[lindex]==0){
                        type--;
                    }
                    if(c[lindex]==k-1){
                        num--;
                    }
                }
                if(type==num) {
                    ans = Math.max(ans, j-l+1);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstring lss = new LongestSubstring();
        System.out.println(lss  .longestSubstring("abbb",3));
    }
}


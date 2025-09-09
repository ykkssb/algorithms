package com.eureka.test.algorithmsv2.hash;

import java.util.HashSet;
import java.util.Set;

/**
 *https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=hash-table
 * 最长连续序列
 * @author : yujie.wang
 * @date: 2025-09-09 18:11
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        // 用 hash 不用数组就是自动过滤重复的
        for(int x :set){
            if(set.contains(x-1)){
                continue;
            }
            int y = x+1;
            while(set.contains(y)){
                y++;
            }
            ans = Math.max(ans, y-x);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(lc.longestConsecutive(a));

    }
}

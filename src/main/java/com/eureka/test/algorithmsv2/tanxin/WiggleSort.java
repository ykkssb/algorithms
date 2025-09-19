package com.eureka.test.algorithmsv2.tanxin;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/wiggle-sort-ii/?envType=problem-list-v2&envId=greedy
 * <p>
 * . 摆动排序 II
 *
 * @author : yujie.wang
 * @date: 2025-09-18 18:08
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        int n = nums.length;
        Arrays.sort(arr);
        int half = (n + 1) / 2;
        for(int i=0,j= half-1, k=n-1;i<n;i+=2,k--,j--){
            nums[i]=arr[j];
                nums[i+1]= arr[k];

        }
        System.out.println("1");
    }

    public static void main(String[] args) {
        WiggleSort ws = new WiggleSort();
        int[] a = {1,3,2,2,3,1};
        ws.wiggleSort(a);
        System.out.println();
    }
}

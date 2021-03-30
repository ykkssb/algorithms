package com.eureka.test.algorithmsv2.array;

/**
 * <p>1534. 统计好三元组 </p>
 * https://leetcode-cn.com/problems/count-good-triplets/
 *
 * @Author : Eric
 * @Date: 2021-03-26 00:23
 */
public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && j > i; j++) {
                for (int k = j + 1; k < n && k > j; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountGoodTriplets cg = new CountGoodTriplets();
        int[] arr = {3, 0, 1, 1, 9, 7};

        System.out.println(cg.countGoodTriplets(arr, 7, 2, 3));

    }
}

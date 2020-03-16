package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>最接近的三数之和</p>
 *
 * @Author : Eric
 * @Date: 2020-03-16 19:26
 */
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            // start i+1 避免数组只有三条
            int start = i + 1, end = n - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) <= Math.abs(target - ans)) {
                    ans = sum;
                }
                if (target < sum) {
                    end--;
                } else if (target > sum) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[] nums = {-4, -1, 2, 1};
        int[] nums = {0, 1, 2};
//        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 0));

    }

}

package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>四数之和</p>
 * https://leetcode-cn.com/problems/4sum/
 *
 * @Author : Eric
 * @Date: 2020-03-18 20:11
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int sum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sum > target) {
                return ans;
            }

            sum = nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4];
            if (sum < target) {
                return ans;
            }


            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int L = j + 1;
                int R = n - 1;
                while (L < R) {

                    sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));

                        while (L < R && nums[L] == nums[L + 1]) {
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;

                    } else if (sum > target) {
                        R--;
                    } else if (sum < target) {
                        L++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] n = {-3,-2,-1,0,0,1,2,3};
//        int[] n = {0, 4, -5, 2, -2, 4, 2, -1, 4};

        System.out.println(fourSum(n, 0));
    }
}

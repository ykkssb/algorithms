package com.eureka.test.algorithmsv2.hash.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/ 和为 K 的子数组
 *
 * @author : yujie.wang
 * @date: 2025-09-11 17:22
 */
public class SubarraySum {

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * todo 前缀和哈希
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n  = nums.length;
        int rem = 0;
        Map<Integer,Integer> map = new HashMap<>();
        // 重要
        map.put(0,1);
        for(int j=0;j<n; j++){
            rem+=nums[j];
            if(map.containsKey(rem-k)) {
                // 0,0,0 返回不是3次而是6次
                ans+=map.get(rem-k);
            }
            map.put(rem,1+map.getOrDefault(rem,0));

        }

        return ans;
    }

    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int[] nums = {1, -1, 0,0,0,0};
        int k = 0;
        System.out.println(ss.subarraySum(nums, k));
    }
}

package com.eureka.test.algorithmsv2.dp.medium;

import org.elasticsearch.common.recycler.Recycler.C;

/**
 * https://leetcode.cn/problems/combination-sum-iv/
 * <p>
 * <p>
 * 组合总和 Ⅳ
 *
 * @author : yujie.wang
 * @date: 2025-09-29 18:22
 */
public class CombinationSum4 {

    int ans = 0;

    /**
     * 部分测试用例 过不去
     */
    public int combinationSum4(int[] nums, int target) {
        dfs(nums, target);
        return ans;
    }

    void dfs(int[] nums, int t) {
        if (t < 0) {
            return;
        }
        if (t == 0) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > t) {
                continue;
            }
            dfs(nums, t - nums[i]);
        }
    }


    /**
     * 当 1≤i≤target 时，如果存在一种排列，其中的元素之和等于 i，则该排列的最后一个元素一定是数组 nums 中的一个元素。
     * 假设该排列的最后一个元素是 num，则一定有 num≤i，对于元素之和等于 i−num 的每一种排列，
     * 在最后添加 num 之后即可得到一个元素之和等于 i 的排列，因此在计算 dp[i] 时，应该计算所有的 dp[i−num] 之和。
     *
     *
     */
    public int combinationSum4Dp(int[] nums, int target) {
        int [] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int n :nums){
                if(n<=i){
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

        CombinationSum4 cs = new CombinationSum4();
        int[] a = {1, 2, 3};
        System.out.println(cs.combinationSum4Dp(a, 7));

    }
}

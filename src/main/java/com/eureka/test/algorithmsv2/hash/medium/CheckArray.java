package com.eureka.test.algorithmsv2.hash.medium;

/**
 * https://leetcode.cn/problems/apply-operations-to-make-all-array-elements-equal-to-zero/ 使数组中的所有元素都等于零
 *
 * @author : yujie.wang
 * @date: 2025-09-11 18:30
 */
public class CheckArray {

    /**
     * https://cloud.tencent.com/developer/article/2393359 差分数组的作用 在差分数组中，每个元素 delta[i]表示从 original[i-1] 到
     * original[i]的变化量。 通过这种方式，我们可以在 O(1) 时间内完成对任意区间的增减操作，而不是逐个元素地进行 O(N) 时间复杂度的修改。
     * <p>
     * https://leetcode.cn/problems/apply-operations-to-make-all-array-elements-equal-to-zero/solutions/1/2772-shi-shu-zu-zhong-de-suo-you-yuan-su-zixv/
     * 差分数组
     * @param nums
     * @param k
     * @return
     */
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = nums[i] - nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (f[i] < 0) {
                return false;
            }
            if (f[i] > 0) {
                if (i + k > n) {
                    return false;
                }
                if (i + k < n) {
                    f[i + k] += f[i];
                }

                f[i] = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckArray ca = new CheckArray();
        // 2 0 1 -2 0 -1
        // 2 0 1 0  0 -1
        // 0 0 1 0  0 -1
//        int[] a = {2, 2, 3, 1, 1, 0};
        int[] a = {1, 3, 1, 1};
        System.out.println(ca.checkArray(a, 2));

    }
}

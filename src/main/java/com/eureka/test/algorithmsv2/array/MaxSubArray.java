package com.eureka.test.algorithmsv2.array;

/**
 * <p>面试题 16.17. 连续数列</p>
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-30 22:54
 */
public class MaxSubArray {

    /**
     * todo v2
     * 方法一：动态规划
     * 贪心算法 \
     * 2021-07-22 测试用例加了【-1】，res=MIN
     * 时间复杂度：O(n)，其中 n 为nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int l = 0, res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            l = Math.max(l + nums[i], nums[i]);
            res = Math.max(res, l);
        }
        return res;
    }

    /**
     * todo v3
     * 方法二：分治
     * 时间复杂度： 故渐进时间复杂度为 O(n)
     * 空间复杂度：递归会使用O(logn) 的栈空间，故渐进空间复杂度为 O(logn)
     * <p>
     * lSum 表示 [l,r] 内以 l 为左端点的最大子段和
     * rSum 表示 [l,r] 内以 r 为右端点的最大子段和
     * max 表示 [l,r] 内的最大子段和
     * sum 表示 [l,r] 的区间和
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        return get(nums, 0, nums.length - 1).max;
    }

    public Status get(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int mid = (l + r) / 2;
        Status lsub = get(a, l, mid);
        Status rsub = get(a, mid + 1, r);
        return pushUp(lsub, rsub);
    }

    /**
     * 也就是说 [l,r] 的max 可能是「左子区间」的的max 和 「右子区间」的的max 中的一个；
     * 它也可能跨越mid，可能是「左子区间」的 rSum 和 「右子区间」的lSum 求和。三者取大。
     */
    public Status pushUp(Status l, Status r) {
        int lsum, rsum, max, sum;
        sum = l.sum + r.sum;
        lsum = Math.max(l.lsum, r.lsum + l.sum);
        rsum = Math.max(r.rsum, l.rsum + r.sum);
        max = Math.max(Math.max(l.max, r.max), l.rsum + r.lsum);
        return new Status(lsum, rsum, sum, max);
    }

    public static void main(String[] args) {
        MaxSubArray ms = new MaxSubArray();
        int[] s = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(ms.maxSubArray2(s));
    }

    public static class Status {
        private int lsum;
        private int rsum;
        private int sum;
        private int max;

        public Status(int lsum, int rsum, int sum, int max) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.sum = sum;
            this.max = max;
        }
    }
}

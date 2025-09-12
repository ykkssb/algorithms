package com.eureka.test.algorithmsv2.hash.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/continuous-subarray-sum/description/?envType=problem-list-v2&envId=hash-table . 连续的子数组和
 *
 * @author : yujie.wang
 * @date: 2025-09-11 15:55
 */
public class CheckSubarraySum {


    /**
     * a%k = b%k，则(a-b) % k = 0
     * todo 同余定理
     * 同余定理：如果两个整数m、n满足n-m能被k整除，那么n和m对k同余
     * <p>
     * 即 ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k
     * <p>
     * 推导 => pre (i) % k = (a0 + a1 + ... + ai) % k = (a0 % k + a1 % k + ... ai % k ) % k
     * （该推导在简化前缀和的时候有用，说明当前前缀和 % k 不会影响后面的前缀和 % k ）
     * 哈希表 存储
     * Key ：pre(i) % k
     * Value： i
     * <p>
     * 遍历过程：
     * <p>
     * 计算前缀和 pre( j ) % k
     * <p>
     * 当pre(j) % k 在哈希表中已存在，则说明此时存在 i 满足 pre(j) % k == pre(i) % k ( i < j )
     * <p>
     * HashMap里，已知Key，可以取到Value 即i的值， 最后 判断 j - i >= 2 是否成立 即可
     * <p>
     * 当 pre(j) % k 不存在于哈希表，则将 (pre(j) % k, j ) 存入哈希表
     * 因在计算 pre(i) = (pre(i-1) + nums[i]) % k 时，pre(i) 只与上一个状态有关
     * <p>
     * 故可以直接用变量pre 替代数组。 那么 求前缀和 % k 的公式就简化为 题解代码中的 remainder = (remainder + nums[i]) % k;
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, -1);
        int n = nums.length;
        int rem = 0;
        for (int i = 0; i < n; i++) {
            rem = (rem + nums[i]) % k;
            // i>0 说明至少2个 满足条件长度 至少为 2
            if(rem==0&&i>0){
                return true;
            }
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                if (i - index >= 2) {
                    return true;
                }

            } else {
                map.put(rem, i);
            }
        }
        return false;
    }


    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumTwo(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i]= nums[i-1]+sum[i-1] ;
        }
        for(int i=2;i<=n;i++){
            set.add((sum[i-2])%k);
            if(set.contains(sum[i]%k)){
                return true;
            }
        }
        return false;
    }



        public static void main(String[] args) {
        CheckSubarraySum c = new CheckSubarraySum();
        int[] nums = {23, 2, 6, 4, 7};
        int k = 7;
        System.out.println(c.checkSubarraySum(nums, k));
    }

}

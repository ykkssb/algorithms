package com.eureka.test.algorithmsv2.array;

/**
 * <p>剑指 Offer 03. 数组中重复的数字</p>
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * @Author : Eric
 * @Date: 2021-03-28 23:55
 */
public class FindRepeatNumber {


    /**
     * todo v2
     * O(n) 哈希存储不考虑
     * 用原地置换法
     *
     * @param nums
     * @return 2 1 0 3 1
     */
    public int findRepeatNumber(int[] nums) {
        int index, i = 0;
        while (i < nums.length) {
            if(nums[i]==i){
                i++;
                continue;
            }
            if(nums[i]==nums[nums[i]]){
                return nums[i];
            }else {
                index = nums[i];
                nums[i] = nums[index];
                nums[index] = index;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        FindRepeatNumber fpn = new FindRepeatNumber();
        int[] num = {2, 1, 0, 3, 1};
        System.out.println(fpn.findRepeatNumber(num));
    }
}

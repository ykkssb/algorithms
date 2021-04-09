package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1752. 检查数组是否经排序和轮转得到</p>
 * https://leetcode-cn.com/problems/check-if-array-is-sorted-and-rotated/
 *
 * @Author : Eric
 * @Date: 2021-03-28 22:24
 */
public class Check {

    /**
     * 核心思想翻转后出现小于的次数唯一
     * @param nums
     * @return
     */
    public boolean check(int[] nums) {
        boolean isRev = nums[0] >= nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (isRev) {
                    isRev = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        for(int i=0;i<26;i++){
            list.add((char) (i + 'a') + "");
        }


        Check c = new Check();
        int[] n = {2, 7, 4, 1, 2, 6, 2};
        System.out.println(c.check(n));
    }
}

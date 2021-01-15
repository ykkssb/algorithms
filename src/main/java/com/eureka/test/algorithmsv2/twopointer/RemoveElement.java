package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>27. 移除元素</p>
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @Author : Eric
 * @Date: 2021-01-15 17:52
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] n = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(re.removeElement(n, 2));
    }

}

package com.eureka.test.algorithms.normal;

import java.util.Arrays;

/**
 * <p>颜色分类 </p>
 *
 * @Author : Eric
 * @Date: 2020-06-02 19:45
 */
public class SortColors {

    /**
     * 方法一: 一次遍历
     * 荷兰国旗问题
     *
     * @param nums
     */
    public void sortColors(int[] nums) {

        int n = nums.length;
        int p0 = 0, cur = 0, p2 = n - 1;

        while (cur <= p2) {

            if (nums[cur] == 0) {
                int tmp = nums[cur];
                nums[cur++] = nums[p0];
                nums[p0++] = tmp;

            } else if (nums[cur] == 2) {
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2--] = tmp;

            } else {
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2, 0, 1, 2, 1};
//        int[] nums = {2, 0, 1};

        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

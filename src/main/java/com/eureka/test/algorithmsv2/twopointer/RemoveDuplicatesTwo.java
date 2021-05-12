package com.eureka.test.algorithmsv2.twopointer;

import java.util.Arrays;

/**
 * <p>80. 删除排序数组中的重复项 II</p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @Author : Eric
 * @Date: 2021-01-18 10:37
 */
public class RemoveDuplicatesTwo {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int count = 0, len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (++len > 1) {
                    continue;
                }
            } else {
                len = 0;
            }
            nums[++count] = nums[i];
        }
        return count + 1;
//        Arrays.stream(nums).forEach(System.out::println);
    }

    /**
     * todo v3
     * 用快慢指针思想
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/kuai-man-zhi-zhen-80-shan-chu-pai-xu-shu-4rnk/
     *
     * @param nums
     */

    public int removeDuplicatesTwo(int[] nums) {
        int maxRepeat = 2;
        int slow = 1;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - maxRepeat + 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesTwo t = new RemoveDuplicatesTwo();
        int[] n = {1, 1, 1, 2, 2, 3};
        System.out.println(t.removeDuplicatesTwo(n));

    }
}

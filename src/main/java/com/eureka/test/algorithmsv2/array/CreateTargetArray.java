package com.eureka.test.algorithmsv2.array;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>1389. 按既定顺序创建目标数组 </p>
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 *
 * @Author : Eric
 * @Date: 2021-03-23 23:47
 */
public class CreateTargetArray {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        CreateTargetArray cta = new CreateTargetArray();
        int[] nums = {1, 2, 3, 4, 0};
        int[] index = {0, 1, 2, 3, 0};
        System.out.println(cta.createTargetArray(nums, index));
    }
}

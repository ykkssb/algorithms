package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <p>989. 数组形式的整数加法</p>
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 *
 * @Author : Eric
 * @Date: 2021-01-22 23:16
 */
public class AddToArrayForm {

    // 1200  , 11
    // 0, 81
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int tmp = A[i] + K % 10;
            K = K / 10;
            if (tmp >= 10) {
                K++;
            }
            list.add(tmp % 10);
        }

        while (K > 0) {
            list.add(K % 10);
            K = K / 10;
        }

        Collections.reverse(list);
        return list;

    }
    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        int[] aa = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
//        int[] aa = {1, 2, 0, 0};
        System.out.println(a.addToArrayForm(aa, 1));
    }

}

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

    // 1011
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K = K / 10;
            if (sum >= 10) {
                K++;
                sum = sum % 10;
            }
            res.add(sum);
        }

        for (; K != 0; ) {
            int sum = K % 10;
            res.add(sum);
            K = K / 10;
        }
        Collections.reverse(res);
        return res;

    }

    public static void main(String[] args) {
        AddToArrayForm a = new AddToArrayForm();
        int[] aa = {2, 0, 5};
        System.out.println(a.addToArrayForm(aa, 1806));
    }

}

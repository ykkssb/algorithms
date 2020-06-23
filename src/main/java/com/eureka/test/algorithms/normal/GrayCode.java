package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>格雷编码</p>
 * https://leetcode-cn.com/problems/gray-code/
 *
 * @Author : Eric
 * @Date: 2020-06-22 19:36
 */
public class GrayCode {
    /**
     * 当n=1时，为[0,1]
     * 当n=2时，为[00,01,11,10]
     * 当n=3时，为[000,001,011,010,110,111,101,100]
     * 如果把前面的0都去掉，就变成：
     * 当n=1时，为[0,1]
     * 当n=2时，为[0,1,11,10]
     * 当n=3时，为[0,1,11,10,110,111,101,100]
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();

        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            res.add(i >> 1 ^ i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(3 >> 1 ^ 3);
        GrayCode code = new GrayCode();
        System.out.println(code.grayCode(3));
    }
}

package com.eureka.test.algorithmsv2.string;

import java.util.List;

/**
 * <p>1221. 分割平衡字符串 </p>
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * @Author : Eric
 * @Date: 2021-01-26 16:41
 */
public class BalancedStringSplit {
    /**
     * 贪心算法
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int res = 0;
        int num = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'R') {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bca";
        s.contains("aa");
        System.out.println(new StringBuffer(s).reverse().toString());
        System.out.println(s.equals(new StringBuffer(s).reverse().toString()) ? 1 : 2);
        char[] st = s.toCharArray();
//        System.out.println(String.valueOf(st));
//        BalancedStringSplit b = new BalancedStringSplit();
//        System.out.println(b.balancedStringSplit(s));
    }
}

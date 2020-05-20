package com.eureka.test.algorithms.hard;

import java.util.List;

/**
 * <p>是否有效数字</p>
 * https://leetcode-cn.com/problems/valid-number/
 *
 * @Author : Eric
 * @Date: 2020-05-19 19:22
 */
public class IsNumber {

    /**
     * 先设定numSeen，dotSeen和eSeen三种boolean变量，分别代表是否出现数字、点和E
     * 然后遍历目标字符串
     * 1.判断是否属于数字的0~9区间
     * 2.遇到点的时候，判断前面是否有点或者E，都需要return false
     * 3.遇到E的时候，判断前面数字是否合理，是否有E，并把numSeen置为false，防止E后无数字
     * 4.遇到-+的时候，判断是否是第一个，如果不是第一个判断是否在E后面，都不满足则return false
     * 5.其他情况都为false
     * <p>
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        boolean numSeen = false;
        boolean doSeen = false;
        boolean eSeen = false;

        char[] a = s.trim().toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= '0' && a[i] <= '9') {
                numSeen = true;
            } else if (a[i] == '.') {
//                if (i == 0) {
//                    return false;
//                }
                if (eSeen || doSeen) {
                    return false;
                }
                doSeen = true;
            } else if (a[i] == 'E' || a[i] == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }

                // 指数e
                numSeen = false;
                eSeen = true;
            } else if (a[i] == '+' || a[i] == '-') {
                if (i != 0 && a[i - 1] != 'E' && a[i - 1] != 'e') {
                    return false;
                }
            }else {
                return false;
            }

        }

        return numSeen;
    }

    public static void main(String[] args) {

        IsNumber is = new IsNumber();
        System.out.println(is.isNumber(". 1"));
    }
}

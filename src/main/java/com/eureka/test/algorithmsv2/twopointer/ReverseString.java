package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>344. 反转字符串</p>
 * https://leetcode-cn.com/problems/reverse-string/submissions/
 *
 * @Author : Eric
 * @Date: 2021-01-15 18:02
 */
public class ReverseString {

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }

    }

    public static void main(String[] args) {

    }
}

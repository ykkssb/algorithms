package com.eureka.test.algorithmsv2.string;

/**
 * <p>541. 反转字符串 II </p>
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * @Author : Eric
 * @Date: 2021-02-01 14:44
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int l = i;
            int r = len - 1 - i < k ? len - 1 : i + k - 1;
            while (l < r) {
                char tmp = c[r];
                c[r] = c[l];
                c[l] = tmp;
                l++;
                r--;
            }

        }
        return String.valueOf(c);

    }

    public static void main(String[] args) {
        String s = "abcdefg";
        ReverseStr r = new ReverseStr();
        System.out.println(r.reverseStr(s, 3));
        System.out.println();

    }
}

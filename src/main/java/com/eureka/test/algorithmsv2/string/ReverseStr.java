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
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length() ; i += 2*k) {
            if (len > i + 2 * k - 1) {
                sb.append(reverse(s.substring(i, i + k)));
                sb.append(s.substring(i + k, i + 2 * k));
            } else {
                if (len <= i + k) {
                    sb.append(reverse(s.substring(i)));
                } else {
                    sb.append(reverse(s.substring(i, i + k)));
                    sb.append(s.substring(i + k));
                }
            }

        }
        return sb.toString();
    }

    public String reverse(String s) {
        char[] ch = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int j = ch.length - 1; j >= 0; j--) {
            sb.append(ch[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdef";
        ReverseStr r = new ReverseStr();
        System.out.println(r.reverseStr(s,2));
        System.out.println();

    }
}

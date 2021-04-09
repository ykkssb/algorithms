package com.eureka.test.algorithmsv2.string;

import java.util.Stack;

/**
 * <p>1694. 重新格式化电话号码</p>
 * https://leetcode-cn.com/problems/reformat-phone-number
 *
 * @Author : Eric
 * @Date: 2021-01-28 16:05
 */
public class ReformatNumber {
    public static void main(String[] args) {
        String s = "testu.email+alex@leetcode.com";
        System.out.println(s.substring(0,s.indexOf("@")));
        System.out.println(s.substring(s.indexOf("@")));
//        ReformatNumber rn = new ReformatNumber();
//        System.out.println(rn.reformatNumber("123 4-5678"));
    }

    public String reformatNumber(String number) {
        int n = 0, i = 0, r = 0;
        char[] ch = number.toCharArray();
        while (i < number.length()) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                ch[n++] = ch[i];
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        n--;
        while (r <= n) {
            if ((n - r + 1) % 4 == 0 && n - r == 3) {
                while (r < n - 1) {
                    sb.append(ch[r++]);
                }
                sb.append("-");
                while (r <= n) {
                    sb.append(ch[r++]);
                }
            } else {
                int next = r + 3;
                for (int j = r; j < next && j <= n; j++) {
                    sb.append(ch[r++]);
                }
                if(r<=n) {
                    sb.append("-");
                }
            }
        }
        return sb.toString();
    }
    // 1-2-3-4-5-6-7-8
    // 8-7-6-5-4-3-2-1
    /**
     * 6-7-8-3-4-5-2-1
     */
}

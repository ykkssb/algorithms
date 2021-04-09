package com.eureka.test.algorithmsv2.string;

/**
 * <p>917. 仅仅反转字母</p>
 * https://leetcode-cn.com/problems/reverse-only-letters/
 *
 * @Author : Eric
 * @Date: 2021-02-01 15:31
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] ch = S.toCharArray();
        int l = 0, r = ch.length - 1;
        StringBuffer sb = new StringBuffer();
        while (l < r) {
            if (!isSt(ch[l])) {
                l++;
            }
            if (!isSt(ch[r])) {
                r--;
            }
            if (isSt(ch[l]) && isSt(ch[r])) {
                char tmp = ch[l];
                ch[l] = ch[r];
                ch[r] = tmp;
                l++;
                r--;
            }
        }
        return String.valueOf(ch);
    }

    public boolean isSt(char ch) {
        if ((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab-cd";
        String s2 = "ccc";
        ReverseOnlyLetters r = new ReverseOnlyLetters();
        System.out.println(r.reverseOnlyLetters(s));
        String res = "abcd";
        System.out.println(res.substring(0,4));
    }
}

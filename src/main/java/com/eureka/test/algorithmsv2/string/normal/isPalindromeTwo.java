package com.eureka.test.algorithmsv2.string.normal;

/**
 * https://leetcode.cn/problems/valid-palindrome/description/?envType=problem-list-v2&envId=string
 * <p>
 * 125. 验证回文串
 *
 * @author : yujie.wang
 * @date: 2025-09-04 17:08
 */
public class isPalindromeTwo {

    public boolean isPalindrome(String s) {
        char[] ch = s.trim().toCharArray();
        int n = ch.length;
        int l = 0, r = n - 1;
        while (l < r) {
            char a = ch[l];
            char b = ch[r];
            boolean ma = match(a);
            boolean mb = match(b);
            if (!ma) {
                l++;
                continue;
            }
            if (!mb) {
                r--;
                continue;
            }
            // 防止 case OP 这种正好相差32的
            boolean ab = Math.abs(a - b) == 32 && (Character.isDigit(a) || Character.isDigit(b));
            if (ma && mb && (Math.abs(a - b) != 32 && a != b) || ab) {
                return false;
            }

//            if(Character.toLowerCase(a) !=Character.toLowerCase(b)){
//                return false;
//            }
            l++;
            r--;
        }
        return true;
    }

    boolean match(char c) {

        // 判断字母  和判断数字
        if (Character.isLetter(c) || Character.isDigit(c)) {
            return true;
        }
        return false;
    }

}

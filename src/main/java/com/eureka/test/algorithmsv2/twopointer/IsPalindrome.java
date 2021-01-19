package com.eureka.test.algorithmsv2.twopointer;

/**
 * <p>125. 验证回文串</p>
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * @Author : Eric
 * @Date: 2021-01-19 21:25
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;

        while (r >= l) {
            if (!isA(ch[l])) {
                l++;
                continue;
            }
            if (!isA(ch[r])) {
                r--;
                continue;
            }
            if (isA(ch[l]) && isA(ch[r])) {
                if (!isEq(ch[l++], ch[r--])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        IsPalindrome is = new IsPalindrome();
        System.out.println(is.isPalindrome(s));
    }

    /**
     * 字段ASCII
     */
    public boolean isEq(int l, int r) {
        if (l == r) return true;
        if (65 <= r && r <= 90 && (l - r == 32)) {
            return true;
        }
        if (97 <= r && r <= 122 && (r - l == 32)) {
            return true;
        }

        return false;
    }

    /**
     * 记录ASCII 数字和字母 48-57| 65-90| 97-122
     *
     * @param s
     * @return
     */
    public boolean isA(int s) {
        if ((48 <= s && s <= 57) || (65 <= s && s <= 90) || (97 <= s && s <= 122)) {
            return true;
        }
        return false;
    }
}


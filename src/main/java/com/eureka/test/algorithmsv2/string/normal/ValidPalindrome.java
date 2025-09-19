package com.eureka.test.algorithmsv2.string.normal;

/**
 * https://leetcode.cn/problems/valid-palindrome-ii/description/?envType=problem-list-v2&envId=greedy
 * <p>
 * 验证回文串 II
 *
 * @author : yujie.wang
 * @date: 2025-09-18 16:22
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                // 存在 case l+1和 r-1都满足条件 必须走循环
                return isCyc(s, l + 1, r) || isCyc(s, l, r - 1);

            }

        }
        return true;
    }

    public boolean isCyc(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "aguokepatgbnvfqmgml cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu lmgmqfvnbgtapekouga";
        System.out.println(vp.validPalindrome(s));
    }
}

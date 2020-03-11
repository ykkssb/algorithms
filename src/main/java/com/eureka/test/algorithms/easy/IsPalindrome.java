package com.eureka.test.algorithms.easy;

/**
 * <p>是否回文串</p>
 *
 * @Author : Eric
 * @Date: 2020-03-10 20:16
 */
public class IsPalindrome {


    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        boolean isPal = false;
        int n = s.length();
        if (n == 0) {
            return isPal;
        }

        int half = 0;
        if (n % 2 == 0) {
            half = n / 2 - 1;
            return isP(s, half, half + 1);
        } else {
            half = n / 2;
            return isP(s, half, half);
        }


    }

    //abba
    public static boolean isP(String s, int i, int j) {
        int L = i, R = j;

        while (L >= 0 && R <= s.length()) {
            if (s.charAt(L) != s.charAt(R)) {
                return false;
            }
            L--;
            R++;
        }

        return true;
    }

    public static void main(String[] args) {
        int s = 112121;
        System.out.println(isPalindrome(s));
    }
}

package com.eureka.test.algorithmsv2.string.hard;

/**
 * @author : yujie.wang
 * @date: 2025-09-03 17:43
 */
public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                if (l > 0) {
                    l--;
                } else {
                    r--;
                }
            }
        }
        String ans = s;
        String a = l>0?  l>r? s.substring(2*l):s.substring(2*l,n-1): s.substring(1);
        for (int j = 0; j < a.length(); j++) {
            ans = a.charAt(j) + ans;
        }
        return ans;
    }

    // aacaaa
    // 0lr0
    public static void main(String[] args) {
        ShortestPalindrome s = new ShortestPalindrome();
        System.out.println(s.shortestPalindrome("ababbbabbaba"));

//        String s = "aba bbbabbaba";
//        String s = "ababbbabbaba";
//        int l = 1, n = s.length();
//        System.out.println(s.substring(l*2));
//        System.out.println(s.substring(l*2+1)); //acecaaa
//        System.out.println(s.substring(1));

    }
}

package com.eureka.test.algorithms.hard;

/**
 * <p>通配符匹配</p>
 * https://leetcode-cn.com/problems/wildcard-matching/
 *
 * @Author : Eric
 * @Date: 2020-04-12 18:13
 */
public class IsMatchTwo {

    public boolean isMatch(String s, String p) {

        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }
        int i = 0, j = 0, iStart = -1, jStart = -1, n = s.length(), m = p.length();
        while (i < n) {

            if (j < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                iStart = i;
                jStart = j++;
            } else if (iStart >= 0) {
                i = iStart++;
                j = jStart + 1;
            } else {
                return false;
            }
        }

        while (j < m && p.charAt(j) == '*') {
            j++;
        }
        return j == m;
    }

    public static void main(String[] args) {
        String s = "aa", p = "*";
//        String s = "acdcb",p = "a*cb";
//        String s = "ho", p = "ho**";
        IsMatchTwo t = new IsMatchTwo();
        System.out.println(t.isMatch(s, p));


//        if(true && false){
//            System.out.println(111);
//        }
    }
}

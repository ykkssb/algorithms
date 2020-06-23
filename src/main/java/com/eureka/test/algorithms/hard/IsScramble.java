package com.eureka.test.algorithms.hard;

/**
 * <p>扰乱字符串</p>
 * https://leetcode-cn.com/problems/scramble-string/
 *
 * @Author : Eric
 * @Date: 2020-06-19 19:32
 */
public class IsScramble {

    /**
     * 递归法
     * 不懂？？？
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[] f = new int[26];
        //按照截取后的s1 长度
        for (int i = 0; i < s1.length(); i++) {

            f[s1.charAt(i) - 'a']++;
            f[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (f[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        IsScramble is = new IsScramble();
        System.out.println(is.isScramble("great", "rtaeg"));
    }

}

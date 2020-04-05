package com.eureka.test.algorithms.easy;

/**
 * <p>外观数列</p>
 *
 * @Author : Eric
 * @Date: 2020-04-04 21:39
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String s = new String();
        int pre = 0, cur = 1;

        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(pre) != str.charAt(cur)) {
                int count = cur - pre;
                s = s + count + "" + str.charAt(pre);
                pre = cur;
            }
        }

        if (pre != cur) {
            int count = cur - pre;
            s = s + count + "" + str.charAt(pre);
        }
        return s;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
        /**
         * 1
         * 11
         * 21
         * 1211
         * 111221
         * 312211
         * 13112221
         */
    }
}

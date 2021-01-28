package com.eureka.test.algorithmsv2.string;

/**
 * <p>1684. 统计一致字符串的数目</p>
 * https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 *
 * @Author : Eric
 * @Date: 2021-01-26 14:55
 */
public class CountConsistentStrings {

    /**
     * todo 按位逻辑运算符
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int al = solve(allowed);
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int t = solve(words[i]);
            if ((t & al) == t) {
                res++;
            }
        }
        return res;
    }

    public int solve(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int tmp = ch[i] - 'a';
            res |= 1 << tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        CountConsistentStrings cc = new CountConsistentStrings();
        System.out.println('b' - 'a');
        String s = "ab";
        String[] b = {"aaab", "abc", "abbd", "abb", "efa"};
        System.out.println(cc.solve(s));
//        System.out.println(cc.countConsistentStrings(s, b));
    }
}

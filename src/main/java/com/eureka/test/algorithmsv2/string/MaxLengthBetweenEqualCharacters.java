package com.eureka.test.algorithmsv2.string;

/**
 * <p>1624. 两个相同字符之间的最长子字符串</p>
 * https://leetcode-cn.com/problems/largest-substring-between-two-equal-characters/
 *
 * @Author : Eric
 * @Date: 2021-01-28 17:36
 */
public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int m = s.lastIndexOf(ch[i] ) - s.indexOf(ch[i] )-1;
            res = Math.max(res, m);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters m = new MaxLengthBetweenEqualCharacters();
        System.out.println(m.maxLengthBetweenEqualCharacters("ba"));
    }
}

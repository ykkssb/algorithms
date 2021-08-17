package com.eureka.test.algorithmsv2.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>1684. 统计一致字符串的数目</p>
 * https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 *
 * @Author : Eric
 * @Date: 2021-01-26 14:55
 */
public class CountConsistentStrings {

    /**
     * todo  v2
     * 按位逻辑运算符
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int i = 0;
        for(char c:allowed.toCharArray()){
            i |=  (1<<(c-'a'));
        }
        boolean isRe = false;
        for(String s:words){
            for(char c : s.toCharArray()){
                if(((1<<(c-'a') & i ) ==0)){
                    isRe = true;
                    break;
                }
            }
            if(!isRe){
                res++;
            }
            isRe = false;
        }
        return res;
    }

    /**
     * 迭代法
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStringsT(String allowed, String[] words) {
        int[] al = new int[26];
        for (char c : allowed.toCharArray()) {
            al[c - 'a']++;
        }
        int res = 0;
        boolean reverse = false;
        for (String s : words) {
            int[] ma = new int[26];
            for (char c : s.toCharArray()) {
                ma[c - 'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                if (al[i] == 0 && ma[i] > 0) {
                    reverse = true;
                    break;
                }
            }
            if (!reverse) {
                res++;
            }
            reverse = false;

        }
        return res;
    }

    static List<Integer> set = Arrays.asList('a' - 'a', 'e' - 'a', 'i' - 'a', 'o' - 'a', 'u' - 'a',
            'A' - 'a', 'E' - 'a', 'I' - 'a', 'O' - 'a', 'U' - 'a');

    public static void main(String[] args) {
        set.contains(1);
        CountConsistentStrings cc = new CountConsistentStrings();
        System.out.println('b' - 'a');
        String s = "ab";
        String[] b = {"aaab", "abc", "abbd", "abb", "efa"};
//        System.out.println(cc.countConsistentStrings(s, b));
    }
}

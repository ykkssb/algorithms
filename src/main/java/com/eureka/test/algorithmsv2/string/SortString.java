package com.eureka.test.algorithmsv2.string;

import com.eureka.test.algorithms.easy.StrStr;
import org.yaml.snakeyaml.events.StreamStartEvent;

/**
 * <p>1370. 上升下降字符串</p>
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 *
 * @Author : Eric
 * @Date: 2021-01-26 15:36
 */
public class SortString {

    /**
     * 难度int 转char
     *
     * @param s
     * @return
     */
    public String sortString(String s) {
        char[] ch = s.toCharArray();
        int[] in = new int[26];
        int di = 0;
        for (char c : ch) {
            in[c - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (in[i] > 0) {
                di++;
            }
        }
        String res = "";
        int l = 0, r = ch.length;
        int len = 0;

        while (l < r) {
            for (int i = 0; i < 26; ++i) {
                if (in[i] > 0 && len++ < di) {
                    res += (char) (i + 'a');
                    in[i]--;
                    l++;
                }
            }
            len = 0;
            for (int i = 25; i >= 0; --i) {
                if (in[i] > 0 && len++ < di) {
                    res += (char) (i + 'a');
                    in[i]--;
                    l++;
                }
            }
            len = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        SortString ss = new SortString();
        String str = "HELLO";
        char[] ch = str.toCharArray();
//        StringBuffer sb = new StringBuffer();
//        for(int i = 0; i<ch.length; i++){
//            sb.append((char)(ch[i] +32));
//        }
        System.out.println(String.valueOf(ch));
//        System.out.println(sb.toString());
        System.out.println(ss.sortString("uhgeaseuktqexmxdiqqkfqdqfbnnnhyg"));
    }
}

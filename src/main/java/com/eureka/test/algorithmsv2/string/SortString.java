package com.eureka.test.algorithmsv2.string;

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
        int[] z = new int[26];
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int t = ch[i] - 'a';
            z[t] = z[t] + 1;
        }
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while (len < ch.length) {
            for (int i = 0; i < z.length; i++) {
                if (z[i] != 0) {
                    len++;
                    sb.append((char) (i + 'a'));
                    z[i] = z[i] - 1;
                }
            }
            for (int i = z.length - 1; i >= 0; i--) {
                if (z[i] != 0) {
                    len++;
                    sb.append((char) (i + 'a'));
                    z[i] = z[i] - 1;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortString ss = new SortString();
        String str= "HELLO";
        char[] ch = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<ch.length; i++){
            sb.append((char)(ch[i] +32));
        }
        System.out.println(sb.toString());
//        System.out.println(ss.sortString("rta"));
    }
}

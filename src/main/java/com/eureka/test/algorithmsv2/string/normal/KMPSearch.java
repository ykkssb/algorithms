package com.eureka.test.algorithmsv2.string.normal;

/**
 * <p>KMP算法</p>
 *  无leetcode
 * @Author : Eric
 * @Date: 2021-04-09 23:36
 */
public class KMPSearch {
    public boolean multiSearch(String big, String smalls) {

        char[] b = big.toCharArray();
        char[] s = smalls.toCharArray();
        int[] next = next(b);
        int j =0;
        for(int i=0;i<b.length;++i){
            while(j>0 && b[i]!=s[j]){
                j = next[j-1];
            }
            if(b[i] == s[j]){
                j++;
                if(j==s.length){
                    return true;
                }
            }
        }
        return false;
    }

    public int[] next(char[] ch){
        int[] next = new int[ch.length];
        int j=0;
        for(int i=1;i<ch.length;++i){
            while(j>0 && ch[i]!= ch[j]){
                j = next[j-1];
            }
            if(ch[i] == ch[j]){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static void main(String[] args) {
        KMPSearch kmp = new KMPSearch();
        String target = "123";

//        System.out.println(target.charAt(0)=='1');

            System.out.println(kmp.multiSearch("abcdabca", "abcde"));
    }
}

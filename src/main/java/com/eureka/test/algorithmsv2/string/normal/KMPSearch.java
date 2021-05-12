package com.eureka.test.algorithmsv2.string.normal;

/**
 * <p>KMP算法</p>
 *  无leetcode
 * @Author : Eric
 * @Date: 2021-04-09 23:36
 */
public class KMPSearch {
    public boolean multiSearch(String big, String smalls) {
        char[] cl = big.toCharArray();
        char[] cr = smalls.toCharArray();
        int[] next = next(cr);
        int j =0;
        for(int i=0;i<cl.length;++i){
            while(j!=0 && cl[i]!=cr[j]){
                j = next[j - 1];
            }
            if(cl[i]==cr[j]){
                j++;
                if(j==smalls.length()){
                    return true;
                }
            }
        }

        return false;
    }

    public int[] next(char[] ch){
        int[] res = new int[ch.length];
        int next=0;
        for(int i=1;i<ch.length;++i){
            while(next!=0 && ch[i]!=ch[next]){
                next = res[next - 1];
            }

            if(ch[i]==ch[next]){
                next++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KMPSearch kmp = new KMPSearch();
        String target = "123";

        System.out.println(target.charAt(0)=='1');

            System.out.println(kmp.multiSearch("ababcdababdc", "ababd"));
    }
}

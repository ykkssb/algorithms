package com.eureka.test.algorithms.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>z字形转化</p>
 *
 * @Author : Eric
 * @Date: 2020-03-09 18:40
 */
public class Zzagtransfer {


    /**
     * 方法一：按行排序
     * 思路
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     *  牛逼
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int n  =s.length();
        List<StringBuffer> list =new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            list.add(new StringBuffer());
        }
        int a = 0, flag=-1;
        for(int i=0;i<s.length();i++){
            list.get(a).append(s.charAt(i));
            if(a==0||a==numRows-1){
                flag= -flag;
            }
            a+=flag;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuffer ss: list) {
            ans.append(ss);
        }

        return ans.toString();
    }


    /**
     * 方法二：按行访问
     * 时间复杂度：O(n)，其中 n==len(s)。每个索引被访问一次。
     * 空间复杂度：O(n)。对于 C++ 实现，如果返回字符串不被视为额外空间，则复杂度为 O(1)
     * <p>
     * l     d    c
     * e   o e  t o
     * e c   l e  d
     * t     e    e
     * </p>
     *
     * @param s
     * @param numRows
     * @return
     */

    // 辅助数组 250902
    public static String convertTwo(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int n  =s.length();
        int len=1, r=numRows-1;
        String ans ="";
        int[][] nn = new int[numRows][n];
        for(int i =0;i<n;i++){
            boolean b = true;
            for(int j =0;j<numRows;j++){
                if(i% (numRows-1)==0){
                    nn[j][i] = len++;
                }else{

                    if(r>0 && b){
                        b =false;
                        r--;
                        nn[r][i] = len++;
                        if(r==1){
                            r = numRows-1;
                        }
                    }
                }
            }
        }

        for(int j= 0;j<numRows;j++){
            for(int i=0;i<n;i++){
                int a = nn[j][i];
                if(a>0 && a<=s.length()){
                    ans+=s.charAt(a-1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "leetcodeleetcode";
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));

    }

}

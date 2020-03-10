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
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int curNum = 0;
        boolean down = false;
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuffer());
        }

        for (Character c : s.toCharArray()) {
            rows.get(curNum).append(c);

            if (curNum == 0 || curNum == numRows - 1) {
                down = !down;
            }
            curNum += down ? 1 : -1;
        }

        StringBuffer ret = new StringBuffer();
        for (StringBuffer sb : rows) {
            ret.append(sb);
        }
        return ret.toString();
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
    public static String convertTwo(String s, int numRows) {
        int n = s.length();
        if (numRows == n) {
            return s;
        }

        StringBuffer sb = new StringBuffer();
        int c = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n - i; j += c) {
                sb.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + c - i < n) {
                    sb.append(s.charAt(j + c - i));
                }

            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leetcodeleetcode";
//        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 4));

    }

}

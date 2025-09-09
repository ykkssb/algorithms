package com.eureka.test.algorithmsv2.string;

/**
 *https://leetcode.cn/problems/excel-sheet-column-title/description/?envType=problem-list-v2&envId=string
 *
 * 本质是1-26进制转换
 * 168. Excel 表列名称
 * @author : yujie.wang
 * @date: 2025-09-04 18:53
 */
public class ConvertToTitle {
    public String convertToTitle(int c) {

        StringBuilder sb  = new StringBuilder();
        while(c>0){
            c--;
            sb.append((char)('A'+c%26));
            c = c/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle c = new ConvertToTitle();
        System.out.println(c.convertToTitle(52));
    }
}

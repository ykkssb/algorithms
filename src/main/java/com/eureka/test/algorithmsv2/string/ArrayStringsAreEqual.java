package com.eureka.test.algorithmsv2.string;

/**
 * <p>1662. 检查两个字符串数组是否相等</p>
 * https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent/solution/
 * @Author : Eric
 * @Date: 2021-01-26 15:21
 */
public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }



}

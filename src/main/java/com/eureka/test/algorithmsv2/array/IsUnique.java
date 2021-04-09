package com.eureka.test.algorithmsv2.array;

/**
 * <p>面试题 01.01. 判定字符是否唯一</p>
 * https://leetcode-cn.com/problems/is-unique-lcci/
 *
 * @Author : Eric
 * @Date: 2021-03-28 23:40
 */
public class IsUnique {

    /**
     * todo v3
     * 不借助数据结构 位运算判断是否唯一
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        int match = 0;
        int p;
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            p = 1 << index;
            if ((p & match) != 0) {
                return false;
            }
            match |= p;
        }
        return true;
    }

    public static void main(String[] args) {
        IsUnique iu = new IsUnique();
        System.out.println(iu.isUnique("abca"));
    }
}

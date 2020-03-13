package com.eureka.test.algorithms.normal;

/**
 * <p>整数转罗马数字</p>
 *
 * @Author : Eric
 * @Date: 2020-03-12 19:21
 */
public class IntToRoman {

    /**
     * 贪心算法 本题目限制 num< 3999
     * 时间复杂度：O(1)最坏条件下，循环的次数为哈希表的长度。
     * 空间复杂度：O(1)
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while (index < 13) {
            while (num >= nums[index]) {
                sb.append(s[index]);
                num -= nums[index];
            }
            index++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 121;

        System.out.println(intToRoman(n));

    }
}

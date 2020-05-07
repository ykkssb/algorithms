package com.eureka.test.algorithms.easy;

/**
 * <p>最后一个单词的长度</p>
 *
 * @Author : Eric
 * @Date: 2020-05-06 17:10
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }


    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        String s = "   hello shwwit";
        System.out.println(l.lengthOfLastWord(s));
    }
}

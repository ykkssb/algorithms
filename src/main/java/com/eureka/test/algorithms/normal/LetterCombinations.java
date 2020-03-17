package com.eureka.test.algorithms.normal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>电话号码的字母组合</p>
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @Author : Eric
 * @Date: 2020-03-17 20:16
 */
public class LetterCombinations {
    public static String[] let = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    static List<String> ans;

    public static List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();

        if (digits.equals("")) {
            return ans;
        }

        StringBuilder sb = new StringBuilder();
        find(digits, 0, sb);
        return ans;
    }

    public static void find(String s, int index, StringBuilder sb) {
        int n = s.length();
        if (index >= n) {
            ans.add(sb.toString());
            return;
        }

        Character c = s.charAt(index);
        String d = let[c - '0'];
        for (int i = 0; i < d.length(); i++) {
            find(s, index + 1, sb.append(d.charAt(i)));
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

//    public static ArrayList<String> res;

//    public static List<String> letterCombinations(String digits) {
//
//        res = new ArrayList<String>();
//        if (digits.equals(""))
//            return res;
//
//        findCombination(digits, 0, "");
//        return res;
//    }
//
//    public static void findCombination(String digits, int index, String s) {
//
//        if (index == digits.length()) {
//            res.add(s);
//            return;
//        }
//
//        Character c = digits.charAt(index);
//        String letters = letterMap[c - '0'];
//        for (int i = 0; i < letters.length(); i++) {
//            findCombination(digits, index + 1, s + letters.charAt(i));
//        }
//
//        return;
//    }


    public static void main(String[] args) {
        String di = "";

//        StringBuilder sb = new StringBuilder();
//        sb.append("abc");
//        System.out.println(sb.delete(2,3));
        System.out.println(letterCombinations(di));
    }
}

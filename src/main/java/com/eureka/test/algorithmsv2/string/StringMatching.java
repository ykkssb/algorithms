package com.eureka.test.algorithmsv2.string;

import java.util.*;

/**
 * <p>1408. 数组中的字符串匹配</p>
 * https://leetcode-cn.com/problems/string-matching-in-an-array/
 *
 * @Author : Eric
 * @Date: 2021-02-20 16:32
 */
public class StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for(int i=0;i<words.length; ++i){
            String s = words[i];
            for(int j=0;j<words.length;++j){
                if(i!=j && words[j].contains(s)){
                    list.add(s);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        StringMatching s = new StringMatching();
        String[] words = {"leetcoder","leetcode","od","hamlet","am"};
        System.out.println(s.stringMatching(words));
    }
}

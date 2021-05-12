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
        Set<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i!=j && words[i].indexOf(words[j])>=0){
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        StringMatching s = new StringMatching();
        String[] words = {"leetcode","et","code"};
        System.out.println(s.stringMatching(words));
    }
}

package com.eureka.test.algorithmsv2.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1002. 查找常用字符</p>
 * https://leetcode-cn.com/problems/find-common-characters/
 *
 * @Author : Eric
 * @Date: 2021-03-28 02:32
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
                int[] ma = new int[26];
                char[] cc = A[0].toCharArray();

                for (int i = 0; i < cc.length; i++) {
                    ma[cc[i] - 'a']++;
                }
                for (int i = 1; i < A.length; i++) {
                    char[] ch = A[i].toCharArray();
                    int[] na = new int[26];
                    for (char c : ch) {
                        na[c - 'a']++;
                    }
                    for (int j = 0; j < 26; j++) {
                        ma[j] = Math.min(na[j], ma[j]);
                    }
                }
                for (int i = 0; i < 26; i++) {
                    while (ma[i]-- > 0) {
                        list.add((char)('a'+i)+"");
                    }
        }
        return list;

    }

    public static void main(String[] args) {
        CommonChars cc = new CommonChars();
        String[] c = {"bella", "label", "roller"};
        System.out.println(cc.commonChars(c));
    }
}

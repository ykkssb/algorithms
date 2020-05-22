package com.eureka.test.algorithms.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文本左右对齐</p>
 * https://leetcode-cn.com/problems/text-justification/solution/shun-zhao-si-lu-xiang-by-powcai/
 *
 * @Author : Eric
 * @Date: 2020-05-22 18:43
 */
public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        int i = 0;
        List<String> res = new ArrayList<>();

        while (i < len) {
            int left = i;
            int first = words[i].length();
            StringBuffer sb = new StringBuffer();
            i++;
            while (i < len) {
                if (first + words[i].length() + 1 > maxWidth) {
                    break;
                }
                first += words[i].length() + 1;
                i++;
            }


            // 仅一行
            if (i == len) {
                for (int j = left; j < len; j++) {
                    sb.append(words[j] + " ");
                }
                // 删除最后一位
                sb.deleteCharAt(sb.length() - 1);
                for (int k = sb.length(); k < maxWidth; k++) {
                    sb.append(" ");
                }
                res.add(sb.toString());

                break;
            }


            int word_len = 0;
            for (int j = left; j < i; j++) {
                word_len += words[j].length();
            }
            // 空格数量
            int space_num = i - left - 1;
            // 剩余空字符数量
            int remain_num = maxWidth - word_len;

            int space = 0, remain = 0;
            if (space_num != 0) {
                space = remain_num / space_num;
                remain = remain_num % space_num;
            }


            for (int j = left; j < i; j++) {
                if (sb.length() > 0) {
                    for (int k = 0; k < space; k++) {
                        sb.append(" ");
                    }
                    if (remain != 0) {
                        sb.append(" ");
                        remain--;
                    }
                }
                sb.append(words[j]);
            }

            for (int j = sb.length(); j < maxWidth; j++) {
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        FullJustify j = new FullJustify();
        System.out.println(j.fullJustify(words, maxWidth).toString());

    }
}

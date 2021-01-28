package com.eureka.test.algorithmsv2.string;

/**
 * <p>1614. 括号的最大嵌套深度 </p>
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * @Author : Eric
 * @Date: 2021-01-26 15:25
 */
public class MaxDepth {
    public int maxDepth(String s) {
        int res = 0;
        int max = 0;
        char[] ch = s.toCharArray();

        for(int i =0;i<ch.length;i++){
            if(ch[i]=='('){
                max++;
            }else if(ch[i]==')'){
                max--;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}

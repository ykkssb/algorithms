package com.eureka.test.algorithmsv2.string;

/**
 * https://leetcode.cn/problems/string-to-integer-atoi/?envType=problem-list-v2&envId=string
 *
 8. 字符串转换整数 (atoi)
 * @author : yujie.wang
 * @date: 2025-09-02 18:49
 */
public class MyAtoi {

    /**
     * 难度在于不能超过 int最大值
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] ch  =s.trim().toCharArray();
        if (ch.length == 0) return 0;

        int ans = 0;
        int sign = 1, max = Integer.MAX_VALUE/10;
        // 妙笔 j
        int j=1;
        if(ch[0]=='-'){
            sign = -1;
        }else if(ch[0]!='+'){
            j = 0;
        }
        for(int i=j;i<ch.length;i++){
            char c = ch[i];
            if(c<'0' || c>'9'){
                break;
            }
            // c>'7'
            //最大值2147483646 最小值-2147483647
            if(ans>max || ans==max && c>'7'){
                return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;

            }
            ans= 10*ans+(c-'0');
        }

        return sign * ans;
    }

    public static void main(String[] args) {
        MyAtoi ma = new MyAtoi();
        System.out.println(ma.myAtoi("2147483646"));
    }
}


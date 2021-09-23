package com.eureka.test.algorithmsv2.string.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>6. Z 字形变换</p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * https://leetcode-cn.com/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
 * @Author : Eric
 * @Date: 2021-09-02 08:23
 */
public class Zconvert {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        int row =numRows, len = s.length();
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0;i<row;++i){
            list.add(new StringBuilder());
        }

        int index = 0, flag = -1;
        for(char c: s.toCharArray()){
            list.get(index).append(c);
            if(index ==0 || index ==numRows-1 ){
                flag= -flag;
            }
            index += flag;
        }
        String res = "";
        for(int i=0;i<list.size();++i){
            res+=list.get(i).toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Zconvert z = new Zconvert();
        System.out.println(z.convert("PAYPALISHIRING", 3));
    }
}

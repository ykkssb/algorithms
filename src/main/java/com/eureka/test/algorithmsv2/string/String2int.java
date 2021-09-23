package com.eureka.test.algorithmsv2.string;

/**
 * <p></p>
 *
 * @Author : Eric
 * @Date: 2021-09-03 12:21
 */
public class String2int {
    public int string2int(String s){
        char[] ch = s.toCharArray();
        int tmp = 0 , res = 0, len=0;
        for(int i=ch.length-1;i>=0; i--){
            int c = ch[i]- '0';
            if(len>1){
                return 0;
            }
            if(match(c)){
                tmp = tmp > 0 ? tmp: 1;
                res  += c *tmp;
                tmp *= 10;
            }else if(ch[i] =='-'){
                len++;
            }

        }
        return res;
    }

    public boolean  match(int c){
        if(c>=48 && c<=57){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String2int m = new String2int();
        System.out.println(m.string2int("123"));
    }

}

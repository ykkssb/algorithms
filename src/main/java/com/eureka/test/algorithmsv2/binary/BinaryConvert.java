package com.eureka.test.algorithmsv2.binary;

/**
 * 十进制转二进制字符串
 *
 * @author : yujie.wang
 * @date: 2025-09-22 17:03
 */
public class BinaryConvert {

    public String BinaryConvert(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(n & 1);
            n = n >> 1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryConvert bc = new BinaryConvert();
        System.out.println(bc.BinaryConvert(13));
    }
}

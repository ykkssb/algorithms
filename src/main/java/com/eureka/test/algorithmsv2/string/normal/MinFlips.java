package com.eureka.test.algorithmsv2.string.normal;

/**
 * <p>1529. 灯泡开关 IV</p>
 * https://leetcode-cn.com/problems/bulb-switcher-iv/
 *
 * @Author : Eric
 * @Date: 2021-03-02 18:50
 */
public class MinFlips {

    /**
     * 模拟
     *
     * @param target
     * @return
     */
    public int minFlips(String target) {
        int res = 0;
        char match = '0';
        char[] ch = target.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != match) {
                match = ch[i];
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MinFlips m = new MinFlips();
        System.out.println(m.minFlips("11011"));
    }
}

package com.eureka.test.algorithmsv2.array.self;

import com.eureka.test.algorithmsv2.array.CountNegatives;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Z形打印二维数组</p>
 *https://www.cnblogs.com/jessie99/p/12409149.html
 * @Author : Eric
 * @Date: 2021-08-02 15:52
 */
public class Zprint {

    public List<List<Integer>> z(int[][] n) {
        List<List<Integer>> res = new ArrayList<>();

        int l = n.length, r = n[0].length;

        int ll = 0, rr = 0;
        while (ll < l - 1) {
            while (rr < r) {
                int i = ll;
                int j = rr;
                List<Integer> list = new ArrayList<>();
                while (j >= 0 && i < l) {
                    list.add(n[i++][j--]);
                }
                res.add(list);
                rr++;
            }
            if (rr == r) {
                int i = ++ll;
                int j = rr - 1;
                List<Integer> list = new ArrayList<>();
                while (j >= 0 && i < l) {
                    list.add(n[i++][j--]);
                }
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Zprint z = new Zprint();
        int[][] n = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(z.z(n));
    }
}

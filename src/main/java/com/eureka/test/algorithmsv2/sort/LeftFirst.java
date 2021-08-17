package com.eureka.test.algorithmsv2.sort;

/**
 * <p>奇数位于偶数前 self</p>
 *
 * @Author : Eric
 * @Date: 2021-08-14 19:35
 */
public class LeftFirst {

    public int[] leftFirst(int[] n) {
        int len = n.length;
        int[] old = new int[len];
        int[] even = new int[len];
        int l = 0 ,o = 0, e =0;
        while (l < len) {
            if (n[l] % 2 == 0) {
                even[e++] = n[l];
            } else {
                old[o++] = n[l];
            }
            l++;
        }
        int index= 0;
        for(int i=0;i<o;++i){
            n[index++] = old[i];
        }
        for(int i=0;i<e;++i){
            n[index++] = even[i];
        }
        return n;
    }

    public static void main(String[] args) {
        LeftFirst l = new LeftFirst();
        int[] t = {2, 1, 3, 10, 9, 11};
        System.out.println(l.leftFirst(t));
    }
}

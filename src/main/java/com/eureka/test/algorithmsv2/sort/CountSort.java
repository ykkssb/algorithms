package com.eureka.test.algorithmsv2.sort;

/**
 * <p>计数排序</p>
 * https://mp.weixin.qq.com/s/L4sTHPizkocAnsVQdc6hqw
 *
 * @Author : Eric
 * @Date: 2021-04-15 10:30
 */
public class CountSort {

    /**
     * 运算量为 n+n+k+n ，总体运算是 3n + k 所以时间复杂度为 O(N+K)；
     * 缺点最大值很大 100w 最小值1 大数组内存浪费
     *
     * @param a
     * @return
     */
    public int[] countSort(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }

        int[] presum = new int[max + 1 - min];
        for (int i : a) {
            presum[i - min]++;
        }
        for (int i = 1; i < a.length; ++i) {
            presum[i] += presum[i - 1];
        }
        int[] res = new int[a.length];
        for (int i = a.length - 1; i >= 0; --i) {
            int index = presum[a[i] - min] - 1;
            res[index] = a[i];
            presum[a[i] - min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSort cs = new CountSort();
        int[] a = {19, 15, 12, 14, 13, 10, 11, 12, 12, 15};
        int[] arr = cs.countSort(a);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

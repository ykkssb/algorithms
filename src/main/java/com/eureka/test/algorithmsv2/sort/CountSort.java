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
     *
     * @param A
     * @return
     */
    public int[] countSort(int[] A) {
        int max = A[0];
        int min = A[0];
        for (int i : A) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int[] presSum = new int[max - min + 1];
        for (int n : A) {
            presSum[n - min]++;
        }
        for (int i = 1; i < presSum.length; i++) {
            presSum[i] = presSum[i - 1] + presSum[i];
        }
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; --i) {
            int index = presSum[A[i] - min] - 1;
            res[index] = A[i];
            presSum[A[i] - min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSort cs = new CountSort();
        int[] a = {19, 15, 12, 14, 13, 10, 11, 12, 12, 15};
        System.out.println(cs.countSort(a));
    }
}

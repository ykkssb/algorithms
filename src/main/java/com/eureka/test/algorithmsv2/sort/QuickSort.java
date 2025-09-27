package com.eureka.test.algorithmsv2.sort;

/**
 * <p>快速排序</p>
 * https://blog.csdn.net/nrsc272420199/article/details/82587933
 *
 * @Author : Eric
 * @Date: 2021-08-18 17:46
 */
public class QuickSort {

    /**
     * todo v2
     *
     * @param low
     * @param high
     */
    private void quickSort(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        int l = low, r = high;
        int tmp = a[l];
        while (l < r) {
            while (l < r && a[r] >= tmp) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] <= tmp) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = tmp;
        quickSort(a, low, l - 1);
        quickSort(a, l + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 97, 0, -1, 22};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

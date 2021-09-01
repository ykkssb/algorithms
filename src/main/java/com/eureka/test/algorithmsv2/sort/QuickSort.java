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
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int l = low;
        int r = high;
        int tmp = arr[l];
        while (l < r) {
            while (l < r && arr[r] >= tmp) {
                r--;
            }
            arr[l] = arr[r];
            while (l < r && arr[l] <= tmp) {
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        quickSort(arr, low, l - 1);
        quickSort(arr, l + 1, high);

    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

}

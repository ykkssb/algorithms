package com.eureka.test.algorithmsv2.array;

/**
 * <p>剑指 Offer II 075. 数组相对排序</p>
 * https://leetcode-cn.com/ problems/0H97ZC/
 *
 * @Author : Eric
 * @Date: 2021-08-18 18:36
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = idx; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    int tmp = arr1[idx];
                    arr1[idx++] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }
        quickSort(arr1, idx, arr1.length - 1);
        return arr1;
    }

    void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int l = low, r = high;
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
        int[] a = {2, 1, 4, 3, 9, 6};
        RelativeSortArray s = new RelativeSortArray();
        s.quickSort(a, 0, 5);
        System.out.println(a);
    }
}

package com.eureka.test.algorithmsv2.sort;

import java.util.Arrays;

/**
 * @author : yujie.wang
 * @date: 2025-09-25 17:10
 */
public class MergeSort {

    /**
     * 归并排序
     * <p>
     * l 0-6 3
     * <p>
     * l 0-3 1
     * <p>
     * l 0-1 0 ->merge 0-1 0
     * <p>
     * r 0-3 1
     * <p>
     * r 2-3 3 ->merge 2-3 3
     * <p>
     * r 0-3 1 ->merge 0-3 1
     * <p>
     * r 4-6 5
     * <p>
     * l 4-4 4 not match
     * <p>
     * l 4-5 4->merge
     * <p>
     * 4-5 4 r 5-6 5->merge
     * <p>
     * 5-6 5 4-6 5->merge
     * <p>
     * 4-6 5 0-6 3->merge 0-6 3
     */
    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    public void merge(int[] arr, int l, int r, int mid) {
        int[] tmp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[index++] = arr[i++];
        }
        while (j <= r) {
            tmp[index++] = arr[j++];
        }
        for (index = 0; index < tmp.length; index++) {
            arr[l + index] = tmp[index];
        }
    }


    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        MergeSort ms = new MergeSort();

        ms.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}

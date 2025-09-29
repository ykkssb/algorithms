package com.eureka.test.algorithmsv2.sort;

/**
 * @author : yujie.wang
 * @date: 2025-09-28 19:37
 */
public class InsertSort {

    public int[] insertSot(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 97, 0, -1, 22};
        InsertSort is = new InsertSort();
        is.insertSot(arr);

        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i+" ");

        }
        System.out.println();
    }


}

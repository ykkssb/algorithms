package com.eureka.test.algorithmsv2.sort;

/**
 * <p>冒泡排序 及优化详解</p>
 * https://www.cnblogs.com/jyroy/p/11248691.html
 * @Author : Eric
 * @Date: 2021-08-18 18:38
 */
public class BubbleSort {

    private static void bublle(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; ++i) {
            for(int j=0 ;j<len-i-1;++j){
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 0, -1, 22};
        bublle(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

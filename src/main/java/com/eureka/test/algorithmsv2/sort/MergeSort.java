package com.eureka.test.algorithmsv2.sort;

import java.util.Arrays;

/**
 * 归并排序 22比较
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
        if(left>= right)   {
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr,mid+1,right);
        merge(arr, left, right, mid);
    }

    void merge(int[] arr, int left,int right, int mid){
        int[] a = new int[right-left+1];
        int l = left, r =mid+1;
        int idx = 0;
        while(l<=mid && r<=right){
            if(arr[l]<arr[r]){
                a[idx++] = arr[l++];
            }else{
                a[idx++]  = arr[r++];
            }
        }
        while(l<=mid){
            a[idx++] = arr[l++];
        }
        while(r<=right){
            a[idx++] = arr[r++];
        }
        for(int i=0;i<idx;i++){
            arr[i+left] = a[i];
        }

    }


    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        MergeSort ms = new MergeSort();

        ms.mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}

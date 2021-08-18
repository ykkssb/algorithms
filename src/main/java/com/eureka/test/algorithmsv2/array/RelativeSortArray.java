package com.eureka.test.algorithmsv2.array;

/**
 * <p>剑指 Offer II 075. 数组相对排序</p>
 * https://leetcode-cn.com/problems/0H97ZC/
 *
 * @Author : Eric
 * @Date: 2021-08-18 18:36
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int l1 = arr1.length, l2 = arr2.length;
        int index =0;
        for(int i=0;i<l2;++i){
            for(int j=index; j<l1; ++j){
                if(arr1[j] == arr2[i]){
                    int tmp = arr1[index];
                    arr1[index++] = arr1[j];
                    arr1[j] = tmp;
                }
            }
        }
        quickSort(arr1, index, l1-1);
        return arr1;
    }

    /**
     * todo v3 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(int[] arr, int low, int high){
        if(high <=low){
            return;
        }
        int tmp = arr[low];
        int l = low, r= high;
        while(l<r){
            while(l<r && arr[r]>= tmp){
                r--;
            }
            arr[l] = arr[r];
            while(l<r && arr[l]<= tmp){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        quickSort(arr, low, l-1);
        quickSort(arr, l+1, high);

    }
}

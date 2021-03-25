package com.eureka.test.algorithmsv2.array;

/**
 * <p>二分查找</p>
 *
 * @Author : Eric
 * @Date: 2021-03-23 22:16
 */
public class HalfSearch {

    public int halfSearch(int[] content, int target) {
        int len = content.length;
        int l = 0, r = content[len - 1];
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target == content[mid]) {
                return 1;
            } else if (target < content[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        HalfSearch h = new HalfSearch();
        int[] con = {1, 3, 5, 7, 9, 10};
        System.out.println(h.halfSearch(con, 5));
    }
}

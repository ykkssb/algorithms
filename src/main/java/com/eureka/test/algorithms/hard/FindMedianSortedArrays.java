package com.eureka.test.algorithms.hard;

/**
 * <p>寻找两个有序数组的中位数</p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @Author : Eric
 * @Date: 2020-03-07 16:30
 */
public class FindMedianSortedArrays {


    /**
     * 解法一
     * 简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
     * 时间复杂度：遍历全部数组 (m+n)
     * <p>
     * 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int[] m = new int[a + b];
        if (a == 0) {
            if (b % 2 == 0) {
                return (nums2[b / 2 - 1] + nums2[b / 2]) / 2;
            } else {
                return nums2[b / 2];
            }
        }

        if (b == 0) {
            if (a % 2 == 0) {
                return (nums1[a / 2 - 1] + nums1[a / 2]) / 2;
            } else {
                return nums1[a / 2];
            }
        }

        int count = 0, i = 0, j = 0;
        while (count != a + b) {
            if (i == a) {
                while (j < b) {
                    m[count++] = nums2[j++];
                }
                break;
            }

            if (j == b) {
                while (i < a) {
                    m[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                m[count++] = nums1[i++];
            } else {
                m[count++] = nums2[j++];
            }


        }

        if (count % 2 != 0) {
            return m[count / 2];
        } else {
            return (m[count / 2 - 1] + m[count / 2]) / 2.0;
        }
    }


    /**
     * 解法二：递归法
     * <p>
     * 时间复杂度：O(log(min(m,n)))，
     * 首先，查找的区间是 [0, m]
     * 而该区间的长度在每次循环之后都会减少为原来的一半。
     * 所以，我们只需要执行log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为O(log(m))。
     * 由于 m≤n，所以时间复杂度是 O(log(min(m,n)))。
     * <p>
     * 空间复杂度：O(1)
     * 我们只需要恒定的内存来存储 9 个局部变量， 所以空间复杂度为 O(1)O
     *
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArraysTwo(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        //A 数组折半查找左边界
        int imin = 0;
        //A 数组折半查找右边界
        int imax = m;

        int halfen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfen - i;
            if (i < imax && B[j - 1] > A[i]) {
                imin = i + 1;
            } else if (i > imin && A[i - 1] > B[j]) {
                imax = i - 1;

            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[j - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) / 2.0;

            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 3, 3, 4};
        int[] n2 = {1, 2};
//        System.out.println(findMedianSortedArrays(n1, n2));
        System.out.println(findMedianSortedArraysTwo(n1, n2));
//        System.out.println((2+3 )/2.0);


    }

}

package com.eureka.test.algorithmsv2.array;

/**
 * <p>1588. 所有奇数长度子数组的和</p>
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/solution/onshi-jian-fu-za-du-o1shi-jian-fu-za-du-by-crj1998/
 *
 * @Author : Eric
 * @Date: 2021-03-25 00:29
 */
public class SumOddLengthSubarrays {
    // todo v3

    /**
     * odd奇数，even偶数
     * * 对于每个元素i(数组中下标为i)来说，要构成奇数长度的子数组
     * 即 i左边的元素个数left+i本身自己一个+右边元素的个数right=奇数
     * 即 left+right=偶数
     * * 满足a+b=偶数就只有两种情况
     * 1. 奇数+奇数=偶数
     * 2. 偶数+偶数=偶数
     * * 1. 所以只需要求得i左边可以选择偶数长度的可能有多少种，即left_even,同样求右边奇数right_even
     * 就可以求出策略1有多少种可能
     * 2. 所以只需要求得i左边可以选择奇数长度的可能有多少种，即left_odd,同样求右边偶数right_odd
     * 就可以求出策略1有多少种可能，注意0也算选择的一种可能
     * * 即元素i在所有奇数长度子数组出现的次数总和是
     * left_odd*right_odd+left_even*right_even
     * * 元素i左边元素共有i个，右边元素共有siz-i-1个
     *
     *
     * 要算长度为奇数的子序列的总的数组和，则需要知道每个数字在各个长度为奇数的子数组中出现的次数，比如说1，4，2，5，3这个序列，
     * 长度为3的子序列（1，4，2）（4，2，5）（2，5，3）中，4出现了2次，2出现了3次等，所以问题的关键就变成了如何找每个数字在各个子序列中出现的次数。
     * 对于数组中的一个数字来说，它前面的数字可以出现0~i-1次，它后面的数字可以出现0~n-i次。要是前面的数字出现偶数次，则i后面的数字也应该出现偶数次，
     * 前面奇数次，后面同样奇数次。
     *
     * l = i+1 , r = n-i;
     * @param arr
     * @return
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int res= 0;
        int l =0,r=0,n=arr.length;
        for(int i=0;i<n; ++i)       {
            l = i+1 ;
            r  = n-i;
            int lj = l/2, lo = (l+1)/2;
            int rj = r/2, ro = (r+1)/2;
            res += arr[i]*(lj*rj + lo*ro);
        }
        return res;
    }

    public static void main(String[] args) {
        SumOddLengthSubarrays s = new SumOddLengthSubarrays();
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(s.sumOddLengthSubarrays(arr));
    }

}

package com.eureka.test.algorithms.easy;

/**
 * <p>粉糖果</p>
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 *
 * @Author : Eric
 * @Date: 2020-03-05 20:40
 */
public class DistributeCandies {

    /**
     * 暴力法
     * 时间复杂度：O(max(√G,N)) G 为糖果数量，N 为人数。
     *
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies(int candies, int num_people) {
        int num[] = new int[num_people];
        int i = 0;
        while (candies > 0) {
            num[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i++;
        }
        return num;
    }

    /**
     * 等差数列求和 之学不会
     * <p>
     * 时间复杂度：O(N)，计算 N 个人的糖果数量。
     * <p>
     * 空间复杂度：O(1)，，除了答案数组只需要常数空间来存储若干变量。
     *
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandiesTwo(int candies, int num_people) {
        int n = num_people;
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p + 0.5);
        int rows = p / n, cols = p % n;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * n;
            if (i < cols) {
                d[i] += i + 1 + rows * n;
            }
            d[cols] += remaining;
        }
        return d;
    }

    public static void main(String[] args) {
        int candais = 19, num_peopler = 4;
        int n[] = distributeCandies(candais, num_peopler);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }
}

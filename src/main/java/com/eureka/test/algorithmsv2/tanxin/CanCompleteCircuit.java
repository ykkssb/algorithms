package com.eureka.test.algorithmsv2.tanxin;

/**
 * https://leetcode.cn/problems/gas-station/submissions/663262754/?envType=problem-list-v2&envId=greedy
 * <p>
 * 加油站
 *
 * @author : yujie.wang
 * @date: 2025-09-16 15:56
 */
public class CanCompleteCircuit {

    /**
     * 自己想的超出时间限制
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = -1, index = -1;
        int rem = 0;
        boolean flag = true;
        for (int i = 0; i < gas.length; i++) {

            if (flag && (gas[i] - cost[i] < 0)) {
                continue;
            } else {
                flag = false;
                for (int j = i; j <= gas.length + i; j++) {
                    rem += gas[getIndex(gas, j)] - cost[getIndex(gas, j)];
                    if (!flag) {
                        index = getIndex(gas, j);
                    }
                    if (rem < 0) {
                        index = -1;
                        flag = true;
                        break;
                    }
                }
                ans = Math.max(ans, index);
                rem = 0;
            }
        }
        return ans;
    }

    public int getIndex(int[] gas, int i) {
        if (i >= gas.length) {
            return i - gas.length;
        }
        return i;
    }


    /**
     * 计算数组中最小油量消耗点，因为题目说了，只要有解就是唯一解，所以这个最小油量消耗点一定是唯一的，至于为什么返回这个最低点的下一个索引值
     * ，热评说得好，“亏空最严重的一个点必须放在最后一步走，等着前面剩余的救助”，如果不从下一个索引出发，就总会经过这个索引，
     * 经过这个索引时，消耗就会小于0
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitTow(int[] gas, int[] cost) {
        int b = 0 ,minb = 0;
        int index= -1;
        for(int i=0;i<gas.length;++i){
            b += gas[i] - cost[i];
            if(b<minb){
                minb = b;
                index = i+1;
            }
        }
        return b>=0?index:-1;
    }

        public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 1, 2};

        CanCompleteCircuit ccc = new CanCompleteCircuit();

        System.out.println(ccc.canCompleteCircuit(a, b));
    }
}

package com.eureka.test.algorithms.easy;

import com.google.common.collect.Maps;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName : OrangeRotting
 * @Description : 腐烂的橘子
 * TIPS：广度优先搜索BFS（Breadth First Search）
 * https://leetcode-cn.com/problems/rotting-oranges/solution/fu-lan-de-ju-zi-by-leetcode-solution/
 * @Author : Eric
 * @Date: 2020-03-04 14:20
 */
public class OrangeRotting {

    /**
     * O(nm)
     * O(nm)
     *
     * @param grid
     * @return
     */
    public static int OrangesRotting(int[][] grid) {

        //辅助定位即将被腐烂的橘子的横坐标
        // 上(-1,0) 左（0,-1） 下(1,0) 右(0,1)
        int[] dr = new int[]{-1, 0, 1, 0};
        //辅助定位即将被腐烂的橘子的纵坐标，对应构成腐烂橘子的四个污染方向
        int[] dc = new int[]{0, -1, 0, 1};

        int R = grid.length, C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = Maps.newHashMap();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    // 转化为索引唯一的一维数组

                    int index = r * C + c;
                    // 存储烂橘子
                    queue.add(index);
                    // 存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                    depth.put(index, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int index = queue.remove();
            // 下标转二维
            int r = index / C, c = index % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                //判断是否存在新鲜橘子
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int nindex = nr * C + nc;
                    queue.add(nindex);
                    // 计次的关键 元素 grid[r][c] 的上下左右元素得腐烂时间应该一致
                    depth.put(nindex, depth.get(index) + 1);
                    ans = depth.get(nindex);
                }
            }
        }

        //检查是否还有新鲜橘子
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int a[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 0}};
//        [2 ,1,1],[0,1,1],[1,0,1]
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[0][i]);

        }
        System.out.println(OrangesRotting(a));
    }


    // 上(-1,0) 左（0,-1） 下(1,0) 右(0,1)
       /* int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        int R = grid.length, C = grid[0].length;
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = Maps.newHashMap();
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    // 一维下标
                    index = r * C + c;
                    queue.add(index);
                    // 首次遍历，时间必然是0
                    depth.put(index, 0);
                }
            }
        }

        while (!queue.isEmpty()) {
            int nindex = queue.remove();
            int r = nindex / C, c = nindex % C;
            for (int k = 0; k < 4; k++) {
               int nr = r+ dr[k];
               int nc = c + dc[k];
                if (0 <= nr && nr < grid.length && 0 <= nc &&
                        nc < grid[0].length && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    index = nr * C + nc;
                    queue.add(index);
                    depth.put(index, depth.get(nindex) + 1);
                    ans = depth.get(index);
                }
            }
        }

        for (int[] row : grid) {
            for (int r : row) {
                if (r == 1) {
                    return -1;
                }
            }
        }
        return ans;*/


}

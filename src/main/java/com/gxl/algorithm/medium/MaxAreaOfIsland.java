package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Objects;

/**
 * 岛屿的最大面积
 * 解题思路：深度优先DFS
 * https://leetcode.cn/problems/max-area-of-island/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/13 17:34
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        var rlt = 0;
        if (Objects.isNull(grid) || grid.length < 1) {
            return rlt;
        }
        int m = grid.length, n = grid[0].length;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                rlt = Math.max(rlt, dfs(grid, i, j));
            }
        }
        return rlt;
    }

    /**
     * 深度优先遍历
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dfs(int[][] grid, int i, int j) {
        var rlt = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return rlt;
        }
        rlt = 1;
        grid[i][j] = 0;
        var t1 = new int[] { 0, 0, -1, 1 };
        var t2 = new int[] { 1, -1, 0, 0 };
        for (var k = 0; k < 4; k++) {
            rlt += dfs(grid, t1[k] + i, t2[k] + j);
        }
        return rlt;
    }

    public static void main(String[] args) {
        Assert.assertEquals(6, new MaxAreaOfIsland().maxAreaOfIsland(new int[][] {
                                                                                   //
                                                                                   { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                                                                                   //
                                                                                   { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                                                                                   //
                                                                                   { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                                                                                   //
                                                                                   { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                                                                                   //
                                                                                   { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                                                                                   //
                                                                                   { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                                                                                   //
                                                                                   { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                                                                                   //
                                                                                   { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
    }
}

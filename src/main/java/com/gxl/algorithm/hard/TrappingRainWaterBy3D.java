package com.gxl.algorithm.hard;

import org.junit.Assert;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 3D接雨水
 * 解题思路：最小堆,始终先处理最低高度的点
 * https://leetcode.cn/problems/trapping-rain-water-ii/description/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/21 18:10
 */
public class TrappingRainWaterBy3D {
    public int trapRainWater(int[][] heights) {
        var rlt = 0;
        if (Objects.isNull(heights) || heights.length < 1 || heights[0].length < 1) {
            return rlt;
        }
        var m = heights.length;
        var n = heights[0].length;
        var visited = new boolean[m][n];
        var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                // 最外层标记为访问过
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    visited[i][j] = true;

                    // 短板效应,始终先处理最低高度的点
                    queue.offer(new int[] { i, j, heights[i][j] });
                }
            }
        }

        var t1 = new int[] { 0, 0, 1, -1 };
        var t2 = new int[] { 1, -1, 0, 0 };
        while (!queue.isEmpty()) {
            // 高度最低的点出队
            var p = queue.poll();

            // 遍历目标的上下左右
            for (var k = 0; k < 4; k++) {
                var newX = p[0] + t1[k];
                var newY = p[1] + t2[k];
                // 判断访问路径边界和是否访问过
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // 外围高度最低的点如果>当前点则计算盛水面积
                    rlt += Math.max(0, p[2] - heights[newX][newY]);
                    visited[newX][newY] = true;

                    // 盛水后需要填充点的高度和外围高度最低的点相同(水流方向),然后入队按照由低到高依次处理
                    queue.offer(new int[] { newX, newY, Math.max(heights[newX][newY], p[2]) });
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        Assert.assertEquals(4, new TrappingRainWaterBy3D().trapRainWater(new int[][] {
                //
                { 1, 4, 3, 1, 3, 2 },
                //
                { 3, 2, 1, 3, 2, 4 },
                //
                { 2, 3, 3, 2, 3, 1 } }));

        Assert.assertEquals(2, new TrappingRainWaterBy3D().trapRainWater(new int[][] {
                //
                { 2, 2, 2 },
                //
                { 2, 1, 2 },
                //
                { 2, 1, 2 },
                //
                { 2, 2, 2 } }));

        Assert.assertEquals(0, new TrappingRainWaterBy3D().trapRainWater(new int[][] {
                //
                { 2, 2, 2 },
                //
                { 2, 1, 2 },
                //
                { 2, 1, 2 },
                //
                { 2, 1, 2 } }));
    }
}

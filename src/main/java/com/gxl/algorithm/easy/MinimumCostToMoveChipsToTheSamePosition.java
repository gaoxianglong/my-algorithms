package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 玩筹码
 * 解题思路：奇数向偶数移动的过程和代价是一样的，偶数向奇数移动的过程和代价也是一样的，也得出奇偶数的个数就是移动代价，最小代价就是奇偶数的最小值
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/6 08:27
 */
public class MinimumCostToMoveChipsToTheSamePosition {
    public int minCostToMoveChips(int[] position) {
        int i = 0, j = 0;
        for (var p : position) {
            if ((p & 1) == 1) {
                i++;
                continue;
            }
            j++;
        }
        return Math.min(i, j);
    }

    public static void main(String[] args) {
        Assert.assertEquals(1, new MinimumCostToMoveChipsToTheSamePosition().minCostToMoveChips(new int[] { 1, 2, 3 }));
        Assert.assertEquals(2, new MinimumCostToMoveChipsToTheSamePosition().minCostToMoveChips(new int[] { 1, 2, 3, 4, 5 }));
    }
}

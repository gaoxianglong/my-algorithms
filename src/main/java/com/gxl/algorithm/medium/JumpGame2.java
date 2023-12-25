package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 跳跃游戏2
 * 解题思路:记录每个路径能跳跃的最大次数
 * https://leetcode.cn/problems/jump-game-ii/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/25 15:47
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int count = 0, max = 0, end = 0, n = nums.length - 1;
        for (var i = 0; i < n; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                count++;
                if (end > n) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var j = new JumpGame2();
        Assert.assertEquals(2, j.jump(new int[] { 2, 3, 1, 1, 4 }));
        Assert.assertEquals(2, j.jump(new int[] { 2, 3, 0, 1, 4 }));
        Assert.assertEquals(0, j.jump(new int[] { 0 }));
        Assert.assertEquals(1, j.jump(new int[] { 1, 2 }));
        Assert.assertEquals(1, j.jump(new int[] { 3, 2, 1 }));
    }
}

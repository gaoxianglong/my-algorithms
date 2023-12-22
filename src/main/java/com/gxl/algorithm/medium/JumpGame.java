package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Objects;

/**
 * 跳跃游戏
 * 解题思路：记录每一个索引位元素能跳跃到的最大位置
 * https://leetcode.cn/problems/jump-game/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/22 11:14
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 1) {
            return false;
        }
        var max = 0;
        for (var i = 0; i < nums.length; i++) {
            // 如果当前索引位大于能跳跃的最大位置则表示无法跳跃到最后一个
            if (i > max) {
                return false;
            }
            // 记录每一个索引位元素能跳跃到的最大位置
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        var j = new JumpGame();
        Assert.assertTrue(j.canJump(new int[] { 2, 3, 1, 1, 4 }));
        Assert.assertFalse(j.canJump(new int[] { 3, 2, 1, 0, 4 }));
        Assert.assertFalse(j.canJump(new int[] { 1, 1, 0, 1, 4 }));
    }
}

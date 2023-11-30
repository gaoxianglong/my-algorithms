package com.gxl.algorithm.hard;

import org.junit.Assert;

/**
 * 接雨水
 * 解题思路：双指针
 * https://leetcode.cn/problems/trapping-rain-water/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/29 18:02
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lm = 0, rm = 0, rlt = 0;
        while (l < r) {
            lm = Math.max(lm, height[l]);
            rm = Math.max(rm, height[r]);
            if (height[l] < height[r]) {
                rlt += lm - height[l++];
                continue;
            }
            rlt += rm - height[r--];
        }
        return rlt;
    }

    public static void main(String[] args) {
        Assert.assertEquals(6, new TrappingRainWater().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}

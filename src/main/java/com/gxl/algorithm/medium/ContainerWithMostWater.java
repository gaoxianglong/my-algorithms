package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Objects;

/**
 * 盛最多水的容器
 * 解题思路：双指针
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/18 11:16
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int rlt = 0;
        if (Objects.isNull(height) || height.length < 1) {
            return rlt;
        }
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                rlt = Math.max(rlt, height[i] * (j - i));
                i++;
                continue;
            }
            rlt = Math.max(rlt, height[j] * (j - i));
            j--;
        }
        return rlt;
    }

    public static void main(String[] args) {
        var c = new ContainerWithMostWater();
        Assert.assertEquals(49, c.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        Assert.assertEquals(1, c.maxArea(new int[] { 1, 1 }));
    }
}

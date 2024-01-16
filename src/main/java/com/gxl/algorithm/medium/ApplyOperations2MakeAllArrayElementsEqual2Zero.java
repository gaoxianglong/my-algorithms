package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 使数组中的所有元素都等于零
 * 解题思路：
 * https://leetcode.cn/problems/apply-operations-to-make-all-array-elements-equal-to-zero/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/1/3 18:59
 */
public class ApplyOperations2MakeAllArrayElementsEqual2Zero {
    public boolean checkArray(int[] nums, int k) {
        var n = nums.length;
        var diff = new int[n];
        diff[0] = nums[0];
        for (var i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        var j = 0;
        for (; j + k < n; j++) {
            if (diff[j] == 0) {
                continue;
            }
            if (diff[j] < 0) {
                return false;
            }
            diff[j + k] += diff[j];
            diff[j] = 0;
        }
        for (j++; j < n; j++) {
            if (diff[j] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var a = new ApplyOperations2MakeAllArrayElementsEqual2Zero();
        Assert.assertTrue(a.checkArray(new int[] { 60, 72, 87, 89, 63, 52, 64, 62, 31, 37, 57, 83, 98, 94, 92, 77, 94, 91, 87, 100, 91, 91, 50, 26 }, 4));
        Assert.assertTrue(a.checkArray(new int[] { 2, 2, 3, 1, 1, 0 }, 3));
        Assert.assertTrue(a.checkArray(new int[] { 1, 1, 2, 2 }, 2));
    }
}

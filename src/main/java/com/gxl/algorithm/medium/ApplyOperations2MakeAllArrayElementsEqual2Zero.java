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
        int n = nums.length, sumD = 0;
        var d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sumD += d[i];
            int x = nums[i];
            x += sumD;
            if (x == 0) {
                continue;
            }
            if (x < 0 || i + k > n) {
                return false;
            }
            sumD -= x; // 直接加到 sumD 中
            d[i + k] += x;
        }
        return true;
    }

    public static void main(String[] args) {
        var a = new ApplyOperations2MakeAllArrayElementsEqual2Zero();
        Assert.assertTrue(a.checkArray(new int[] { 2, 2, 3, 1, 1, 0 }, 3));
    }
}

package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Objects;

/**
 * 删掉一个元素以后全为 1 的最长子数组
 * 解题思路：递推
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/14 14:06
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int count = 0, prevCount = 0, rlt = 0;
        if (Objects.isNull(nums) || nums.length < 1) {
            return rlt;
        }
        for (var n : nums) {
            if (n == 1) {
                count++;
                prevCount++;
            } else {
                count = prevCount;
                prevCount = 0;
            }
            rlt = Math.max(rlt, count);
        }
        return rlt == nums.length ? --rlt : rlt;
    }

    public static void main(String[] args) {
        var l = new LongestSubarrayOf1sAfterDeletingOneElement();
        Assert.assertEquals(5, l.longestSubarray(new int[] { 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 }));
        Assert.assertEquals(7, l.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }));
        Assert.assertEquals(2, l.longestSubarray(new int[] { 1, 1, 1 }));
    }
}

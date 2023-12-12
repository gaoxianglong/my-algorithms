package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 划分数组使最大差为K
 * 解题思路：贪心算法
 * https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/12 17:13
 */
public class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        int i = 0, j = 1, n = nums.length, rlt = 1;
        Arrays.sort(nums);
        for (; j < n; j++) {
            if (nums[j] - nums[i] > k) {
                rlt++;
                i = j;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var p = new PartitionArraySuchThatMaximumDifferenceIsK();
        Assert.assertEquals(2, p.partitionArray(new int[] { 3, 6, 1, 2, 5 }, 2));
        Assert.assertEquals(2, p.partitionArray(new int[] { 1, 2, 3 }, 1));
        Assert.assertEquals(3, p.partitionArray(new int[] { 2, 2, 4, 5 }, 0));
    }
}

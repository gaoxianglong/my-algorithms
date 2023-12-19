package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.Objects;

/**
 * 二分查找
 * https://leetcode.cn/problems/binary-search/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/19 17:12
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        var rlt = -1;
        if (Objects.isNull(nums) || nums.length < 1) {
            return rlt;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            var mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                rlt = mid;
                break;
            }
            if (nums[mid] < target) {
                l = ++mid;
            } else {
                r = --mid;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var b = new BinarySearch();
        Assert.assertEquals(4, b.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
    }
}

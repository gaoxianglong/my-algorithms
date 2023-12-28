package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 搜索旋转排序数组
 * 解题思路：二分查找
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/28 11:07
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int rlt = -1, l = 0, r = nums.length - 1;
        while (l <= r) {
            var mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                rlt = mid;
                break;
            }
            // 左边有序
            if (nums[l] <= nums[mid]) {
                // 目标值在nums[l]-nums[mid]区间
                if (target >= nums[l] && target <= nums[mid]) {
                    r = --mid;
                } else {
                    l = ++mid;
                }
            }
            // 右边有序
            else {
                // 目标值在nums[mid]-nums[r]区间
                if (target >= nums[mid] && target <= nums[r]) {
                    l = ++mid;
                } else {
                    r = --mid;
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var s = new SearchInRotatedSortedArray();
        Assert.assertEquals(4, s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        Assert.assertEquals(-1, s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, -1));
        Assert.assertEquals(-1, s.search(new int[] { 1 }, 0));
    }
}

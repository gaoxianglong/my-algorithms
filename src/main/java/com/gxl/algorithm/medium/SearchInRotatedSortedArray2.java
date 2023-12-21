package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 搜索旋转排序数组2
 * 解题思路：二分查找
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/20 21:59
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            var mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                return true;
            }
            // 避开重复值
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
                continue;
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
        return false;
    }

    public static void main(String[] args) {
        var s = new SearchInRotatedSortedArray2();
        Assert.assertTrue(s.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0));
        Assert.assertFalse(s.search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3));
    }
}

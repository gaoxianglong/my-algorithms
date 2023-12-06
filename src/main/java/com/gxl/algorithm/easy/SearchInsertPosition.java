package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 搜索插入位置
 * 解题思路：二分查找
 * https://leetcode.cn/problems/search-insert-position/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/6 09:08
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, rlt = nums.length;
        while (l <= r) {
            var mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = ++mid;
            } else {
                rlt = mid;
                r = --mid;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var sip = new SearchInsertPosition();
        Assert.assertEquals(2, sip.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        Assert.assertEquals(1, sip.searchInsert(new int[] { 1, 3, 5, 6, 7, 8 }, 2));
    }
}

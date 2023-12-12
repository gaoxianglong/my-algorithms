package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 移除元素
 * 解题思路：双指针
 * https://leetcode.cn/problems/remove-element/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/12 08:42
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0, n = nums.length;
        for (; j < nums.length; j++) {
            // 当前值不等于val时指针i移动,最后指针长度区间数据就是有效数据
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        var r = new RemoveElement();
        Assert.assertEquals(4, r.removeElement(new int[] { 1, 2, 3, 4, 4, 5 }, 4));
        Assert.assertEquals(6, r.removeElement(new int[] { 1, 2, 3, 4, 4, 5 }, 6));
    }
}

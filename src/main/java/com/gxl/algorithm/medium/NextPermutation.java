package com.gxl.algorithm.medium;

import java.util.Arrays;
import java.util.Objects;

/**
 * 下一个排列
 * 解题思路：双指针,寻找左右边界
 * https://leetcode.cn/problems/next-permutation/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/27 18:26
 */
public class NextPermutation {
    /**
     * 找到下一个更大的排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return;
        }
        // 左边界
        var i = nums.length - 2;
        // 从右往左找，比如4 1 5 3,下一个更大的排列为4 3 1 5，那么1为左边界
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        // 如果越界则表示已经是最大排列，反转即可
        if (i < 0) {
            reserve(nums, 0);
            return;
        }
        // 右边界
        var j = nums.length - 1;
        // 如果右边界的值大于左边界的值则找到右边界
        for (; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        // 左右边界值互换
        swap(nums, i, j);
        // 对左边界之后的数列排序，得到下一个更大的排列
        reserve(nums, ++i);
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    private void reserve(int[] nums, int i) {
        var j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        var n = new NextPermutation();
        var t1 = new int[] { 1, 3, 2 };
        n.nextPermutation(t1);
        System.out.println(Arrays.toString(t1));

        t1 = new int[] { 3, 2, 1 };
        n.nextPermutation(t1);
        System.out.println(Arrays.toString(t1));
    }
}

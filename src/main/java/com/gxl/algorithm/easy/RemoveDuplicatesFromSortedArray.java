package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.UUID;

/**
 * 删除有序数组中的重复项
 * 解题思路：双指针
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/submissions/498125211/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/1/24 22:56
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int rlt = 1, size = nums.length;
        if (nums.length < 2) {
            return rlt;
        }
        int i = 0, j = 1;
        for (; j < size; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                rlt++;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
//        var r = new RemoveDuplicatesFromSortedArray();
//        var nums = new int[] { 1, 1, 2, 3, 3, 3, 4 };
//        Assert.assertEquals(4, r.removeDuplicates(nums));
//        System.out.println(Arrays.toString(nums));
//        RemoveDuplicatesFromSortedArray a =null;
//        System.out.println(a.toString());
//        boolean a = false;
//        //a |= true;
//        a = a || false;
//        System.out.println(a);

        String a = "a";
        String b = "b";
        System.out.println(a.compareTo(b) <= 0);
    }
}

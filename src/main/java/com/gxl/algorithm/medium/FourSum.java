package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 解题思路：双指针
 * https://leetcode.cn/problems/4sum/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/1/1 20:54
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var rlt = new ArrayList<List<Integer>>();
        var n = nums.length;
        Arrays.sort(nums);
        for (var i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (var j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (var k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    var l = n - 1;
                    while (k < l && (long) nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    }
                    if (k >= l) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        rlt.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var f = new FourSum();
        System.out.println(f.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        System.out.println(f.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
    }
}

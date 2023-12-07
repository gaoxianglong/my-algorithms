package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 三数之和
 * 解题思路：排序+双指针
 * https://leetcode.cn/problems/3sum/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/7 08:21
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 1) {
            return null;
        }
        var rlt = new ArrayList<List<Integer>>();
        // 排序去重
        Arrays.sort(nums);
        var n = nums.length;
        for (var i = 0; i < n; i++) {
            // 越界处理和去重判断
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            var k = n - 1;
            // 双指针运算
            for (var j = i + 1; j < n; j++) {
                // 越界处理和去重判断
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0) {
                    rlt.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        // 排序后为-4，-1, -1，0, 1, 2
        System.out.println(new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}

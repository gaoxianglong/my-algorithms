package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 解题思路：双指针
 * https://leetcode.cn/problems/3sum-closest/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/21 20:58
 */
public class _3sumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int rlt = 0, min = Integer.MAX_VALUE, n = nums.length;
        Arrays.sort(nums);
        for (var i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                var sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                var dv = Math.abs(target - sum);
                if (min > dv) {
                    min = dv;
                    rlt = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var sc = new _3sumClosest();
        Assert.assertEquals(2, sc.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
        Assert.assertEquals(0, sc.threeSumClosest(new int[] { 0, 0, 0 }, 1));
    }
}

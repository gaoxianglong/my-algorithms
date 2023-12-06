package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 两数之和
 * 解题思路：hash表,首先查询哈希表中是否存在target - x，不存在就将x插入哈希表，如果target-y=x则返回x和y的索引
 * https://leetcode.cn/problems/two-sum/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/6 08:46
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var map = new ConcurrentHashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        var rlt = new TwoSum().twoSum(new int[] { 2, 3 }, 5);
        Assert.assertEquals(1, rlt[0]);
        Assert.assertEquals(0, rlt[1]);
    }
}

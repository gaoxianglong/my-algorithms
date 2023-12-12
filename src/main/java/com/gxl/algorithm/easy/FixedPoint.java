package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.Objects;

/**
 * 不动点
 * 解题思路：二分查找
 * https://leetcode.cn/problems/fixed-point/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/12 17:03
 */
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        var rlt = -1;
        if (Objects.isNull(arr) || arr.length < 1) {
            return rlt;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            var mid = ((r - l) >> 1) + l;
            if (arr[mid] < mid) {
                l = ++mid;
            } else if (arr[mid] > mid) {
                r = --mid;
            } else {
                // 继续往左寻找最小索引
                rlt = mid;
                r = --mid;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var f = new FixedPoint();
        Assert.assertEquals(3, f.fixedPoint(new int[] { -10, -5, 0, 3, 7 }));
        Assert.assertEquals(0, f.fixedPoint(new int[] { 0, 2, 5, 8, 17 }));
        Assert.assertEquals(-1, f.fixedPoint(new int[] { -10, -5, 3, 4, 7, 9 }));
    }
}

package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 位1的个数
 * 解题思路：位运算(>>右移运算、&运算)
 * https://leetcode.cn/problems/number-of-1-bits/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/28 08:55
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        var count = 0;
        for (var i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var b = new NumberOf1Bits();
        Assert.assertEquals(1, b.hammingWeight(1));
        Assert.assertEquals(3, b.hammingWeight(11));
        Assert.assertEquals(2, b.hammingWeight(20));
    }
}

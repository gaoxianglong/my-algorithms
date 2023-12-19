package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 检查二进制字符串
 * 解题思路：判断字符串中是否有01,找规律
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/19 15:51
 */
public class CheckBinaryString {
    public boolean checkOnesSegment(String s) {
        // 非前导0，0个连续1：0..0
        // 1组连续1：1..1
        return s.indexOf("01") == -1;
    }

    public static void main(String[] args) {
        var c = new CheckBinaryString();
        Assert.assertFalse(c.checkOnesSegment("1001"));
        Assert.assertTrue(c.checkOnesSegment("110"));
        Assert.assertFalse(c.checkOnesSegment("1100111"));
        Assert.assertTrue(c.checkOnesSegment("1111"));
        Assert.assertFalse(c.checkOnesSegment("0000011"));
    }
}

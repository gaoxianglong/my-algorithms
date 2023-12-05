package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 字符串相乘
 * 解题思路：模拟竖式乘法
 * https://leetcode.cn/problems/multiply-strings/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/5 08:53
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        var rlt = "0";
        if (num1.equals("0") || num2.equals("0")) {
            return rlt;
        }
        for (var i = num1.length() - 1; i >= 0; i--) {
            var builder = new StringBuilder();
            for (var j = num1.length() - 1; j > i; j--) {
                builder.append('0');
            }
            var carry = 0;
            for (var k = num2.length() - 1; k >= 0; k--) {
                var t1 = num1.charAt(i) - '0';
                var t2 = num2.charAt(k) - '0';
                var t3 = t1 * t2 + carry;
                carry = t3 / 10;
                builder.append(t3 % 10);
            }
            if (carry > 0) {
                builder.append(carry);
            }
            rlt = addStrings(rlt, builder.reverse().toString());
        }
        return rlt;
    }

    /**
     * 竖式加法
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        var builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            var t1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            var t2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            var t3 = t1 + t2 + carry;
            carry = t3 / 10;
            builder.append(t3 % 10);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Assert.assertEquals("156", new MultiplyStrings().multiply("12", "13"));
        Assert.assertEquals("56088", new MultiplyStrings().multiply("123", "456"));
    }
}

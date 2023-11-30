package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 字符串相加
 * 解题思路：模拟竖式加法
 * https://leetcode.cn/problems/add-strings/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/29 18:14
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        var rlt = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            var t1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            var t2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            var t3 = t1 + t2 + carry;
            // 求个位
            rlt.append(t3 % 10);
            // 去各位
            carry = t3 / 10;
        }
        return rlt.reverse().toString();
    }

    public static void main(String[] args) {
        Assert.assertEquals("444", new AddStrings().addStrings("123", "321"));
    }
}

package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 回文数
 * 解题思路:对半比较
 * https://leetcode.cn/problems/palindrome-number/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/11 19:15
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x % 10 == 0 || x < 0) {
            return false;
        }
        var temp = 0;
        while (x > temp) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        return x == temp || x == temp / 10;
    }

    public static void main(String[] args) {
        var p = new PalindromeNumber();
        Assert.assertTrue(p.isPalindrome(1));
        Assert.assertTrue(p.isPalindrome(121));
        Assert.assertFalse(p.isPalindrome(122));
        Assert.assertTrue(p.isPalindrome(0));
    }
}

package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.Objects;

/**
 * 找出数组中的第一个回文字符串
 * 解题思路:双指针,从外向内走之中间
 * https://leetcode.cn/problems/find-first-palindromic-string-in-the-array/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/6 08:13
 */
public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        if (Objects.isNull(words) || words.length < 1) {
            return "";
        }
        for (var word : words) {
            int l = 0, r = word.length() - 1;
            while (l < r) {
                if (word.charAt(l) != word.charAt(r)) {
                    break;
                }
                l++;
                r--;
            }
            if (l >= r) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Assert.assertEquals("ada", new FindFirstPalindromicStringInTheArray().firstPalindrome(new String[] { "abc", "car", "ada", "racecar", "cool" }));
    }
}

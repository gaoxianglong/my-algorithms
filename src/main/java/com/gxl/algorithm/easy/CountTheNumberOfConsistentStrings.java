package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 统计一致字符串的数目
 * 解题思路：
 * https://leetcode.cn/problems/count-the-number-of-consistent-strings/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/13 19:26
 */
public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        var rlt = 0;
        for (var w : words) {
            var i = 0;
            for (; i < w.length(); i++) {
                if (allowed.indexOf(w.charAt(i)) == -1) {
                    break;
                }
            }
            if (i == w.length()) {
                rlt++;
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        var c = new CountTheNumberOfConsistentStrings();
        Assert.assertEquals(2, c.countConsistentStrings("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }));
        Assert.assertEquals(7, c.countConsistentStrings("abc", new String[] { "a", "b", "c", "ab", "ac", "bc", "abc" }));
    }
}

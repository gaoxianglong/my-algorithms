package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 最长回文子串
 * 解题思路：中心点扩展
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/10 23:28
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return null;
        }
        int n = s.length() - 1, max = 0, l = 0, r = 0;
        for (var i = 0; i < n; i++) {
            // 基数扩散:aba,以为b中心向左右扩散
            var t1 = diffuse(i, i, s);
            // 偶数扩散:abba,以bb为中心向左右扩散
            var t2 = diffuse(i, i + 1, s);
            var t3 = t1[2] > t2[2] ? t1 : t2;
            if (max < t3[2]) {
                max = t3[2];
                l = t3[0];
                r = t3[1];
            }
        }
        return s.substring(l, r + 1);
    }

    /**
     * 以每一个字符为中心点左右扩展找到回文子串
     * @param l
     * @param r
     * @param s
     * @return
     */
    public int[] diffuse(int l, int r, String s) {
        // 边界判断
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] { ++l, --r, r - l };
    }

    public static void main(String[] args) {
        var l = new LongestPalindromicSubstring();
        Assert.assertEquals("bab", l.longestPalindrome("babad"));
        Assert.assertEquals("bb", l.longestPalindrome("cbba"));
        Assert.assertEquals("bb", l.longestPalindrome("bb"));
        Assert.assertEquals("b", l.longestPalindrome("b"));
    }
}

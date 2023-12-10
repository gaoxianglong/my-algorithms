package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 无重复字符的最长子串
 * 解题思路：滑动窗口,记录左指针，时间复杂度O(n)
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/10 20:38
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }
        var map = new ConcurrentHashMap<Character, Integer>();
        int rlt = 0, n = s.length(), leftIndex = 0;
        for (var i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 重复字段的下一个作为起始位,且前面已经计算过,所以左指针只能向后膨胀
                leftIndex = Math.max(map.get(s.charAt(i)) + 1, leftIndex);
            }
            map.put(s.charAt(i), i);
            rlt = Math.max(rlt, i - leftIndex + 1);
        }
        return rlt;
    }

    public static void main(String[] args) {
        var l = new LongestSubstringWithoutRepeatingCharacters();
        Assert.assertEquals(3, l.lengthOfLongestSubstring("dvdf"));
        Assert.assertEquals(2, l.lengthOfLongestSubstring("abba"));
        Assert.assertEquals(8, l.lengthOfLongestSubstring("abcaqwert"));
    }
}

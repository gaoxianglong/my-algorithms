package com.gxl.algorithm.medium;

/**
 * 字符串中最多数目的子序列
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/9/24 19:04
 */
public class 字符串中最多数目的子序列 {
    public static long maximumSubsequenceCount(String text, String pattern) {
        // 分别统计pattern中每个字符出现的次数
        int c1 = 0, c2 = 0;
        var rlt = 0L;
        for (var t : text.toCharArray()) {
            if (t == pattern.charAt(1)) {
                // 统计当前字符之前有多少满足的子序列
                rlt += c1;
                // pattern中第2个字符出现的次数
                c2++;
            }
            if (t == pattern.charAt(0)) {
                // pattern中第1个字符出现的次数
                c1++;
            }
        }
        return rlt + Math.max(c1, c2);
    }

    public static void main(String[] args) {
        //        System.out.println(maximumSubsequenceCount("acac", "ac"));
        //        System.out.println(maximumSubsequenceCount("ccc", "cc"));
        System.out.println(maximumSubsequenceCount("abb", "ab"));
    }
}

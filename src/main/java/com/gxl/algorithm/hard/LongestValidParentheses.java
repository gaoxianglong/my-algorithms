package com.gxl.algorithm.hard;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

/**
 * 最长有效括号
 * 解题思路：栈,记录左索引
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/1/16 18:40
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        var max = 0;
        var stack = new LinkedList<Integer>() {
            {
                // 记录边界值
                push(-1);
            }
        };
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            stack.pop();
            // )))()情况时从索引3开始
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            max = Math.max(max, i - stack.peek());
        }

        return max;
    }

    public static void main(String[] args) {
        //        var l = new LongestValidParentheses();
        //        Assert.assertEquals(6, l.longestValidParentheses("((()))"));
        //        Assert.assertEquals(2, l.longestValidParentheses("())()"));
        //        Assert.assertEquals(2, l.longestValidParentheses("))()"));
        //        Assert.assertEquals(4, l.longestValidParentheses("()()"));
        //        Assert.assertEquals(2, l.longestValidParentheses("(()"));
        //        Assert.assertEquals(4, l.longestValidParentheses("(())"));
        //        Assert.assertEquals(0, l.longestValidParentheses(""));
        //        Assert.assertEquals(4, l.longestValidParentheses(")()())"));
        String input = "0000";
        byte[] bytes = input.getBytes();
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);
        long crc32Value = checksum.getValue();
        System.out.println(crc32Value);
        System.out.println(String.format("%010d", crc32Value));

        var tt = "VID20240122221158.aa.mp4".split("\\.");
        System.out.println(tt[tt.length - 1]);
        System.out.println("VID20240122221158.aa.mp4".substring(0,"VID20240122221158.aa.mp4".lastIndexOf("mp4")) + "dog");
    }
}

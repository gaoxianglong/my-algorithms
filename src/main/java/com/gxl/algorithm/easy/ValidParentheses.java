package com.gxl.algorithm.easy;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 有效的括号
 * 解题思路：基于栈
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/12 08:24
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        var map = new ConcurrentHashMap<Character, Character>() {
            {
                put('}', '{');
                put(']', '[');
                put(')', '(');
            }
        };
        var stack = new LinkedList<Character>();
        for (var c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c).equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
                return false;
            }
            // 假设以{([的顺序入栈，最后则以])}出栈
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var v = new ValidParentheses();
        Assert.assertTrue(v.isValid("{{([()])}}"));
        Assert.assertFalse(v.isValid("[(}]"));
        Assert.assertFalse(v.isValid("]"));
    }
}

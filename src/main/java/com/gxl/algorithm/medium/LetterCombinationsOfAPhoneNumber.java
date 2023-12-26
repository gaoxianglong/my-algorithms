package com.gxl.algorithm.medium;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 电话号码的数字组合
 * 解题思路:DFS
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/26 17:16
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        var rlt = new ArrayList<String>();
        if (Objects.isNull(digits) || digits.isBlank()) {
            return rlt;
        }
        var map = new ConcurrentHashMap<Character, List<Character>>() {
            {
                put('2', Arrays.asList('a', 'b', 'c'));
                put('3', Arrays.asList('d', 'e', 'f'));
                put('4', Arrays.asList('g', 'h', 'i'));
                put('5', Arrays.asList('j', 'k', 'l'));
                put('6', Arrays.asList('m', 'n', 'o'));
                put('7', Arrays.asList('p', 'q', 'r', 's'));
                put('8', Arrays.asList('t', 'u', 'v'));
                put('9', Arrays.asList('w', 'x', 'y', 'z'));
            }
        };
        dfs(map, digits, 0, rlt, new StringBuilder());
        return rlt;
    }

    private void dfs(Map<Character, List<Character>> map, String digits, int index, List<String> list, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        var c = map.get(digits.charAt(index));
        for (var i = 0; i < c.size(); i++) {
            sb.append(c.get(i));
            dfs(map, digits, index + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        var l = new LetterCombinationsOfAPhoneNumber();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("234"));
        System.out.println(l.letterCombinations("2"));
    }
}

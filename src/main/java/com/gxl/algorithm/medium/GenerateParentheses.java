package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 解题思路：DFS深度优先
 * https://leetcode.cn/problems/generate-parentheses/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/1/3 14:43
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        var rlt = new ArrayList<String>();
        dfs(rlt, n, 0, 0, new StringBuilder());
        return rlt;
    }

    private void dfs(List<String> list, int n, int i, int j, StringBuilder sb) {
        if (sb.length() == n << 1) {
            list.add(sb.toString());
            return;
        }
        if (i < n) {
            sb.append("(");
            dfs(list, n, i + 1, j, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (j < i) {
            sb.append(")");
            dfs(list, n, i, j + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        var g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(2));
        System.out.println(g.generateParenthesis(3));
    }
}

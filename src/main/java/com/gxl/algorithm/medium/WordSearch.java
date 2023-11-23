package com.gxl.algorithm.medium;

import org.junit.Assert;

/**
 * 单词搜索
 * 解题思路：回溯算法(DFS深度优先)
 * https://leetcode.cn/problems/word-search/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/23 19:50
 */
public class WordSearch {
    private boolean rlt;

    public boolean exist(char[][] board, String word) {
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                dfs(board, word, i, j, 0);
            }
        }
        return rlt;
    }

    private void dfs(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return;
        }
        // 当索引和单词长度一致时表示找到了
        if (index == word.length() - 1) {
            rlt = true;
            return;
        }
        var temp = board[i][j];
        board[i][j] = '.';
        var t1 = new int[] { 0, 0, -1, 1 };
        var t2 = new int[] { 1, -1, 0, 0 };
        for (var k = 0; k < 4; k++) {
            // 四周依次寻找
            dfs(board, word, i + t1[k], j + t2[k], index + 1);
        }
        board[i][j] = temp;
    }

    public static void main(String[] args) {
        Assert.assertTrue(new WordSearch().exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } }, "SEE"));
    }
}

package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和2
 * 解题思路：DFS
 * https://leetcode.cn/problems/combination-sum-ii/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/26 19:30
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var rlt = new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, rlt, new LinkedList());
        return rlt;
    }

    private void dfs(int[] candidates, int target, int index, List<List<Integer>> lists, LinkedList list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (var i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, lists, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        var c = new CombinationSum2();
        System.out.println(c.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        System.out.println(c.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5));
    }
}

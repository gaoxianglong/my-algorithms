package com.gxl.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合综合
 * 解题思路:DFS
 * https://leetcode.cn/problems/combination-sum/description/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/26 15:05
 */
public class Description {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var rlt = new ArrayList<List<Integer>>();
        dfs(candidates, target, 0, rlt, new LinkedList<>());
        return rlt;
    }

    /**
     * DFS深度优先
     * @param candidates
     * @param target
     * @param index
     * @param list
     */
    private void dfs(int[] candidates, int target, int index, List<List<Integer>> lists, LinkedList<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (var i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, lists, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Description().combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(new Description().combinationSum(new int[] { 2, 3, 5 }, 8));
        System.out.println(new Description().combinationSum(new int[] { 2 }, 1));
    }
}

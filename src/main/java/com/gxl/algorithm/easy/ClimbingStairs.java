package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 爬楼梯
 * 解题思路：动态规划，递推子问题的解得到最终解
 * https://leetcode.cn/problems/climbing-stairs/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/20 11:05
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        var dp = new int[n + 1];
        // 只有一种方式到达0阶和1阶
        dp[0] = 1;
        dp[1] = 1;
        for (var i = 2; i <= n; i++) {
            // 在爬楼梯问题中，状态转移方程 dp[i] = dp[i - 1] + dp[i - 2] 的形成基于问题的特定条件和逻辑。
            // 这个问题通常被描述为：给定一个楼梯，你可以一次走一阶或两阶台阶，问到达楼顶有多少种不同的方法。这里是它的逻辑基础：
            // 最后一步的选择：当你站在第 i 阶台阶上时，你只能从第 i-1 阶台阶或第 i-2 阶台阶到达这里。这是因为每次你只能走一阶或两阶。
            // 从 i-1 阶到达 i 阶：如果你的最后一步是从第 i-1 阶走上来的，那么到达第 i-1 阶的方法数就是到达第 i 阶的方法之一。到达第 i-1 阶的方法数为 dp[i - 1]。
            // 从 i-2 阶到达 i 阶：类似地，如果你的最后一步是从第 i-2 阶走两步上来的，那么到达第 i-2 阶的方法数就是到达第 i 阶的另一种方法。到达第 i-2 阶的方法数为 dp[i - 2]。
            // 总结状态转移：因此，到达第 i 阶的总方法数 dp[i] 是这两种情况的总和：dp[i - 1] + dp[i - 2]。
            // 这个状态转移方程有效地捕获了问题的本质：每一步都是基于前一步或前两步的结果。这是动态规划的典型应用，通过将问题分解成子问题并利用这些子问题的解来解决整体问题。
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        var c = new ClimbingStairs();
        Assert.assertEquals(2, c.climbStairs(2));
        Assert.assertEquals(3, c.climbStairs(3));
    }
}

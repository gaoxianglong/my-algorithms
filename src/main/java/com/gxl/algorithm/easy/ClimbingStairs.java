package com.gxl.algorithm.easy;

import org.junit.Assert;

/**
 * 爬楼梯
 * 解题思路：动态规划
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
            // 状态转移方程为dp[i-1] + dp[i-2]
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

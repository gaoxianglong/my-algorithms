package com.gxl.algorithm.easy;

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
    //    public int climbStairs(int n) {
    //
    //    }

    public static void main(String[] args) {
        // 预期输出1、2、3、4、5、6、7、8、9、10

        // 统计100以内的偶数个数，但不包括18、28、38、48
        int i = 0;
        int j = 0;
        for (; i < 100; i++) {
            if (i % 2 == 0) {
                ++j;
            }
        }
        System.out.println(j);
    }
}

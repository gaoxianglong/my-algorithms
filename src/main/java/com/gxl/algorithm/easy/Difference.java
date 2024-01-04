package com.gxl.algorithm.easy;

import java.util.Arrays;
import java.util.Objects;

/**
 *     差分数组的基本概念
 *     差分数组 diff 用于表示原数组 nums 中相邻元素之间的差值。对于 diff 中的每个元素，有 diff[i] = nums[i] - nums[i - 1]。
 *     这意味着，如果你从差分数组的第一个元素开始，逐个累加 diff 中的元素，你将重构出原数组 nums。
 *
 *     实现区间增加
 *     当我们在差分数组 diff 上执行 diff[i] += val 时，我们实际上是将原数组 nums 中从索引 i 开始的所有后续元素都增加了 val。
 *     这是因为差分数组的累加会将这个增加的值传递到后面的所有元素。
 *
 *     接着，当我们执行 diff[j+1] -= val（当然，前提是 j+1 在数组范围内），我们实际上是在原数组 nums 中索引 j+1 的位置抵消了之前的增加。
 *     这样，从 j+1 到数组结束的元素将不会体现出之前在 i 到 j 的增加。
 *
 *     例子
 *     假设 nums = [1, 2, 3, 4, 5]，我们想要在区间 [1, 3] 中每个元素都增加 2，即最后的 nums 应该变成 [1, 4, 5, 6, 5]。
 *
 *     初始化差分数组 diff 为 [1, 1, 1, 1, 1]（因为 nums[i] - nums[i - 1] 每次都是 1）。
 *
 *     执行操作：
 *
 *     diff[1] += 2 → diff 变为 [1, 3, 1, 1, 1]。
 *     diff[4] -= 2 → diff 变为 [1, 3, 1, 1, -1]。
 *     累加差分数组 diff 以重构 nums：
 *
 *     nums[0] = diff[0] = 1，
 *     nums[1] = diff[0] + diff[1] = 1 + 3 = 4，
 *     nums[2] = diff[0] + diff[1] + diff[2] = 1 + 3 + 1 = 5，
 *     nums[3] = diff[0] + diff[1] + diff[2] + diff[3] = 1 + 3 + 1 + 1 = 6，
 *     nums[4] = diff[0] + diff[1] + diff[2] + diff[3] + diff[4] = 1 + 3 + 1 + 1 - 1 = 5。
 *     最终，nums 变为 [1, 4, 5, 6, 5]，符合我们的预期。
 *
 *     通过这种方法，差分数组允许我们用两次操作代替对整个区间的遍历，从而在处理多个这样的区间操作时提高效率。
 */
public class Difference {
    /**
     * 区间加法
     * @param i
     * @param j
     * @param val
     * @return
     */
    public int[] increment(int[] source, int i, int j, int val) {
        if (Objects.isNull(source) || source.length < 1) {
            return new int[] {};
        }
        var n = source.length;
        if (i < 0 || j >= n) {
            return new int[] {};
        }
        // 定义差分数组
        var diff = new int[n];
        diff[0] = source[0];
        // 差分计算
        for (var k = 1; k < n; k++) {
            // 当前值=当前值-上一个值,得到差
            diff[k] = source[k] - source[k - 1];
        }
        diff[i] += val;
        if (j + 1 < n) {
            diff[j + 1] -= val;
        }
        // 数组还原
        for (var k = 1; k < n; k++) {
            // 当前值=上一个值+差
            diff[k] = diff[k - 1] + diff[k];
        }
        return diff;
    }

    public static void main(String[] args) {
        var d = new Difference();
        System.out.println(Arrays.toString(d.increment(new int[] { 0, 0, 1, 1, 2 }, 0, 3, 5)));
        System.out.println(Arrays.toString(d.increment(new int[] { 0, 0, 1, 1, 2 }, 0, 4, 1)));
        System.out.println(Arrays.toString(d.increment(new int[] { 1, 1, 1, 1 }, 0, 3, 2)));
    }
}

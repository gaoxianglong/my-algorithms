package com.gxl.algorithm.easy;

/**
 * 数组元素和数字和的绝对差
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/9/26 14:31
 */
public class 数组元素和数字和的绝对差 {
    public static int differenceOfSum(int[] nums) {
        int s1 = 0, s2 = 0;
        for (var n : nums) {
            // 元素和
            s1 += n;
            // 数字和
            while (n > 0) {
                s2 += n % 10;
                n /= 10;
            }
        }
        // 绝对差
        return s1 - s2;
    }

    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[] { 1, 15, 6, 3 }));
    }
}

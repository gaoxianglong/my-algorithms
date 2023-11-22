package com.gxl.algorithm.medium;

import java.util.Arrays;
import java.util.Objects;

/**
 * 旋转图像
 * 解题思路：水平翻转+主对角线翻转
 * https://leetcode.cn/problems/rotate-image/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/22 20:03
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (Objects.isNull(matrix) || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        var m = matrix.length;
        var n = matrix[0].length;
        // 水平翻转
        for (var i = 0; i < m >> 1; i++) {
            for (var j = 0; j < n; j++) {
                matrix[i][j] ^= matrix[m - i - 1][j];
                matrix[m - i - 1][j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[m - i - 1][j];
            }
        }
        // 对角线翻转
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < i; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }

    public static void main(String[] args) {
        var matrix = new int[][] {
                                   //
                                   { 5, 1, 9, 11 },
                                   //
                                   { 2, 4, 8, 10 },
                                   //
                                   { 13, 3, 6, 7 },
                                   //
                                   { 15, 14, 12, 16 } };
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

package com.gxl.algorithm.easy;

import java.util.ArrayDeque;

/**
 * 棒球比赛
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2024/9/25 16:39
 */
public class 棒球比赛 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
    }

    /**
     * 输入：ops = ["5","-2","4","C","D","9","+","+"]
     * 输出：27
     * 解释：
     * "5" - 记录加 5 ，记录现在是 [5]
     * "-2" - 记录加 -2 ，记录现在是 [5, -2]
     * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
     * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
     * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
     * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
     * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
     * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
     * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
     * @param operations
     * @return
     */
    public static int calPoints(String[] operations) {
        // 双端队列
        var deQue = new ArrayDeque<Integer>();
        for (var o : operations) {
            switch (o) {
                case "C":
                    // 移除栈顶元素
                    deQue.pop();
                    break;
                case "D":
                    // 栈顶结果*2并入栈
                    deQue.push(deQue.peek() << 1);
                    break;
                case "+":
                    // 栈顶的2个元素相加，结果入栈
                    var iterator = deQue.iterator();
                    deQue.offerFirst(iterator.next() + iterator.next());
                    break;
                default:
                    // 数字直接入栈
                    deQue.push(Integer.parseInt(o));
            }
        }
        var rlt = 0;
        while (!deQue.isEmpty()) {
            // 出栈结果相加
            rlt += deQue.pop();
        }
        return rlt;
    }
}

package com.gxl.algorithm.medium;

import org.junit.Assert;

import java.util.LinkedList;

/**
 * 最小栈
 * 解题思路：使用辅助栈
 * https://leetcode.cn/problems/min-stack/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/28 19:28
 */
public class MinStack {
    private LinkedList<Integer> l1 = new LinkedList<>();
    private LinkedList<Integer> l2 = new LinkedList<>() {
                                       {
                                           push(Integer.MAX_VALUE);
                                       }
                                   };

    public void push(int val) {
        l1.push(val);

        // 最小栈的栈顶元素即为当前阶段栈中的最小值
        l2.push(Math.min(l2.peek(), val));
    }

    /**
     * 弹出栈顶元素
     */
    public void pop() {
        l1.pop();
        l2.pop();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public int top() {
        return l1.peek();
    }

    /**
     * 获取最小栈元素
     * @return
     */
    public int getMin() {
        return l2.peek();
    }

    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(1);

        // 栈顶排列为1、-3、0、-2
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(-2, minStack.getMin());
        minStack.pop();
        Assert.assertEquals(-2, minStack.getMin());

        minStack = new MinStack();
        minStack.push(-200);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(1);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        Assert.assertEquals(-200, minStack.getMin());
    }
}

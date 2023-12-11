package com.gxl.algorithm.medium;

import com.gxl.algorithm.common.ListNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 删除链表的倒数第N个结点
 * 解题思路：基于栈删除
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/11 19:41
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var vn = new ListNode(-1, head);
        var cn = vn;
        var stack = new LinkedList<ListNode>();
        while (Objects.nonNull(cn)) {
            stack.push(cn);
            cn = cn.next;
        }
        // 删除倒数第n个元素
        for (var i = 0; i < n; i++) {
            stack.pop();
        }
        // 获取倒数第n个元素的上一个元素
        var prev = stack.pop();
        prev.next = prev.next.next;
        return vn.next;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }
}

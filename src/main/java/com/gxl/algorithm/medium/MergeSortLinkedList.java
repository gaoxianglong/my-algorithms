package com.gxl.algorithm.medium;

import java.util.Objects;

/**
 * 链表排序
 * 解题思路：归并排序+快慢指针
 * https://leetcode.cn/problems/7WHec2/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/24 19:12
 */
public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // 找到链表的中间节点
        var middle = findMiddle(head);

        // 直至拆分为单个元素
        var left = sortList(head);
        var right = sortList(middle);

        // 合并
        return merge(left, right);
    }

    /**
     * 找到中间节点
     * @param node
     * @return
     */
    private ListNode findMiddle(ListNode node) {
        // 定义快/慢指针
        ListNode slow = node, fast = node, prev = null;
        // 快指针每次移动两步，慢指针每次移动一步。当快指针到达链表尾部时，慢指针所在的位置就是链表的中间位置
        // 对于奇数长度的链表，慢指针会指向中间节点，对于偶数长度的链表，慢指针会指向两个中间节点中的其中一个
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表,分成2部分
        prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        // 虚拟节点用于处理边界问题
        var vn = new ListNode(-1);
        var cn = vn;

        while (Objects.nonNull(n1) && Objects.nonNull(n2)) {
            if (n1.val < n2.val) {
                cn.next = n1;
                n1 = n1.next;
            } else {
                cn.next = n2;
                n2 = n2.next;
            }
            // 指向合并链表的尾部，以便能够持续向后添加新的节点
            cn = cn.next;
        }

        // 处理某个链表的剩余节点
        if (Objects.nonNull(n1)) {
            cn.next = n1;
        }
        if (Objects.nonNull(n2)) {
            cn.next = n2;
        }
        return vn.next;
    }

    public static class ListNode {
        int      val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }

    public static void main(String[] args) {
        var head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(new MergeSortLinkedList().sortList(head));
    }
}

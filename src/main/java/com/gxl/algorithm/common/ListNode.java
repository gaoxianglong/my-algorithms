package com.gxl.algorithm.common;

/**
 * ListNode
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/27 08:44
 */
public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}

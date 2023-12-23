package com.gxl.algorithm.easy;

import com.gxl.algorithm.common.ListNode;
import org.junit.Assert;

import java.util.Objects;

/**
 * 回文链表
 * 解题思路：快慢指针
 * https://leetcode.cn/problems/palindrome-linked-list/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/22 15:11
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        var l1 = reverse(findMid(head));
        while (Objects.nonNull(l1)) {
            if (head.val != l1.val) {
                return false;
            }
            head = head.next;
            l1 = l1.next;
        }
        return true;
    }

    /**
     * 链表反转
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (Objects.nonNull(head)) {
            var next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 获取中间元素
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        // 定义快/慢指针
        ListNode slow = head, fast = head;
        // 快指针每次移动两步，慢指针每次移动一步。当快指针到达链表尾部时，慢指针所在的位置就是链表的中间位置
        // 对于奇数长度的链表，慢指针会指向中间节点，对于偶数长度的链表，慢指针会指向两个中间节点中的其中一个
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        var p = new PalindromeLinkedList();
        Assert.assertTrue(p.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        Assert.assertTrue(p.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
    }
}

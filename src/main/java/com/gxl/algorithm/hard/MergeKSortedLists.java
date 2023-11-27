package com.gxl.algorithm.hard;

import com.gxl.algorithm.common.ListNode;

import java.util.Objects;

/**
 * 合并K个升序链表
 * 解题思路：分治算法-归并排序
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/27 08:51
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        var mid = (l + r) >> 1;
        var left = merge(lists, l, mid);
        var right = merge(lists, mid + 1, r);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var vn = new ListNode(-1);
        var cn = vn;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                cn.next = l1;
                l1 = l1.next;
            } else {
                cn.next = l2;
                l2 = l2.next;
            }
            cn = cn.next;
        }
        if (Objects.nonNull(l1)) {
            cn.next = l1;
        }
        if (Objects.nonNull(l2)) {
            cn.next = l2;
        }
        return vn.next;
    }

    public static void main(String[] args) {
        var lists = new ListNode[] {
                                     //
                                     new ListNode(1, new ListNode(2, new ListNode(7))),
                                     //
                                     new ListNode(3, new ListNode(4, new ListNode(9))),
                                     //
                                     new ListNode(6, new ListNode(7, new ListNode(8))),
                                     //
                                     new ListNode(6, new ListNode(7, new ListNode(8))) };
        System.out.println(new MergeKSortedLists().mergeKLists(lists));
    }
}

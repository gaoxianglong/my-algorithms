package com.gxl.algorithm.easy;

import com.gxl.algorithm.common.ListNode;

import java.util.Objects;

/**
 * 合并2个有序链表
 * 解题思路：虚拟节点
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/27 08:43
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var vn = new ListNode(-1);
        var cn = vn;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val < list2.val) {
                cn.next = list1;
                list1 = list1.next;
            } else {
                cn.next = list2;
                list2 = list2.next;
            }
            cn = cn.next;
        }
        if (Objects.nonNull(list1)) {
            cn.next = list1;
        }
        if (Objects.nonNull(list2)) {
            cn.next = list2;
        }
        return vn.next;
    }

    public static void main(String[] args) {
        System.out.println(new MergeTwoSortedLists().mergeTwoLists(new ListNode(1, new ListNode(10)), new ListNode(2, new ListNode(5))));
    }
}

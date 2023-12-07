package com.gxl.algorithm.medium;

import com.gxl.algorithm.common.ListNode;

import java.util.Objects;

/**
 * 两数相加
 * 解题思路：模拟竖式加法
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/12/7 17:31
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1) || Objects.isNull(l2)) {
            return null;
        }
        // 虚拟节点
        var vn = new ListNode(-1);
        var cn = vn;
        var carry = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || carry > 0) {
            int t1 = 0, t2 = 0, t3 = 0;
            if (Objects.nonNull(l1)) {
                t1 = l1.val;
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)) {
                t2 = l2.val;
                l2 = l2.next;
            }
            t3 = t1 + t2 + carry;
            carry = t3 / 10;
            cn.next = new ListNode(t3 % 10);
            cn = cn.next;
        }
        return vn.next;
    }

    public static void main(String[] args) {
        // 342+465=807
        var l = new ListNode(2, new ListNode(4, new ListNode(3)));
        var r = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(new AddTwoNumbers().addTwoNumbers(l, r));
    }
}

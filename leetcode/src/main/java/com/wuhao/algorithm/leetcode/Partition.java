package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;

public class Partition {
    public static final String NAME = "86. 分隔链表";

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;

        // 找到第一个大于等于x的前驱节点
        ListNode prev = root;
        while (prev.next != null && prev.next.val < x) {
            prev = prev.next;
        }

        // 向后遍历，如果节点小于x，则移动到前驱节点后，并作为新的前驱节点
        ListNode current = prev;
        while (current.next != null) {
            if (current.next.val < x) {
                ListNode temp = prev.next;
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = temp;
                prev = prev.next;
            } else {
                current = current.next;
            }
        }
        return root.next;
    }
}

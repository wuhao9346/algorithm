package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;

public class ReverseBetween {
    public static final String NAME = "92. 反转链表 II";

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = prev.next;
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = temp;
        }
        return root.next;
    }
}

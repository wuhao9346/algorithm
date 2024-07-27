package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;

public class ReverseKGroup {
    public static final String NAME = "25. K 个一组翻转链表";

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode prev = root;
        ListNode current = prev;
        while (current != null) {
            // 找到分组尾
            for (int i = 0; i < k; i++) {
                if (current.next == null) {
                    current = null;
                    break;
                }
                current = current.next;
            }
            if (current == null) {
                break;
            }
            // 头插法
            current = prev.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = prev.next;
                prev.next = current.next;
                current.next = current.next.next;
                prev.next.next = temp;
            }
            prev = current;
        }
        return root.next;
    }
}

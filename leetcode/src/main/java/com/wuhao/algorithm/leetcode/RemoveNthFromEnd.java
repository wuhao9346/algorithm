package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;

public class RemoveNthFromEnd {
    public static final String NAME = "19. 删除链表的倒数第 N 个结点";

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode delPreNode = root;
        ListNode current = root;
        for (int i = 0; i < n; i++) {
            if (current == null) {
                return head;
            }
            current = current.next;
        }

        while (current != null) {
            current = current.next;
            if (current != null) {
                delPreNode = delPreNode.next;
            }
        }
        ListNode delNode = delPreNode.next;
        delPreNode.next = delNode.next;
        delNode.next = null;
        return root.next;
    }
}

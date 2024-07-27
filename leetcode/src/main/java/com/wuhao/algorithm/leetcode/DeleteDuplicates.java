package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;

public class DeleteDuplicates {
    public static final String NAME = "82. 删除排序链表中的重复元素 II";

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode prev = root;
        int count = 0;
        ListNode current = prev.next;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                count++;
                current = current.next;
                continue;
            }
            if (count == 0) {
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
                count = 0;
            }
        }
        return root.next;
    }
}

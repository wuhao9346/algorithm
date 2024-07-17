package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;

/**
 * 141.环形链表
 */
public class HasCycle {
    public static final String NAME = "141.环形链表";

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        } while (fast != null && !fast.equals(slow));
        return fast != null;
    }
}

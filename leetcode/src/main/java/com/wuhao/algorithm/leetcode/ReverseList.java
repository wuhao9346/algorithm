package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;

import static com.wuhao.algorithm.leetcode.structure.ListNode.*;
import static com.wuhao.algorithm.leetcode.structure.ListNode.buildListNode;

/**
 * LCR 024.反转链表
 */
public class ReverseList {
    public static final String NAME="LCR 024.反转链表";


    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prevNode;
            prevNode = head;
            head = next;
        }
        return prevNode;
    }
}

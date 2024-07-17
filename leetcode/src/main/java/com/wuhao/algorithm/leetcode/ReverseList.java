package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;

import static com.wuhao.algorithm.leetcode.structure.ListNode.*;
import static com.wuhao.algorithm.leetcode.structure.ListNode.buildListNode;

/**
 * LCR 024.反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        print(reverseList(buildListNode(new int[]{1, 2, 3, 4, 5})));
        print(reverseList(buildListNode(new int[]{1, 2})));
        print(reverseList(buildListNode(new int[]{})));
    }

    public static ListNode reverseList(ListNode head) {
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

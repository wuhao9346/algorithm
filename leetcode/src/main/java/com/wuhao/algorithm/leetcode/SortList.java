package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;

public class SortList {
    public static final String NAME = "148. 排序链表";

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到中间的node
        ListNode tail = head;
        ListNode middle = head;
        while (tail.next != null) {
            tail = tail.next;
            if (tail.next != null) {
                tail = tail.next;
                middle = middle.next;
            }
        }
        // 断开链表
        ListNode head2 = middle.next;
        middle.next = null;
        // 对两边分别排序，然后合并
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head2);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return root.next;
    }
}

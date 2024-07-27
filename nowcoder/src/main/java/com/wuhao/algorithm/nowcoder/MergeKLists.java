package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.common.structure.ListNode;

import java.util.List;

public class MergeKLists {
    public static final String NAME = "NC51 合并k个已排序的链表";

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        ListNode[] minNodes = new ListNode[lists.size()];
        int minValue = 1001;
        int minIndex = 0;
        for (int i = 0; i < lists.size(); i++) {
            minNodes[i] = lists.get(i);
            if (minNodes[i] != null && minNodes[i].val < minValue) {
                minValue = minNodes[i].val;
                minIndex = i;
            }
        }
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (minNodes[minIndex] != null) {
            prev.next = minNodes[minIndex];
            prev = prev.next;

            minNodes[minIndex] = minNodes[minIndex].next;

            minValue = 1001;
            for (int i = 0; i < minNodes.length; i++) {
                if (minNodes[i] != null && minNodes[i].val < minValue) {
                    minValue = minNodes[i].val;
                    minIndex = i;
                }
            }
        }

        return head.next;
    }

    /**
     * 递归+归并
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        return recursion(lists, 0, lists.size() - 1);
    }

    public ListNode recursion(List<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists.get(left);
        }
        int mid = (right + left) / 2;
        return merge(recursion(lists, left, mid), recursion(lists, mid + 1, right));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return result.next;
    }
}

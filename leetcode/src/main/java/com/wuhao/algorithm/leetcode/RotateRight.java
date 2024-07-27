package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;

public class RotateRight {
    public static final String NAME = "61. 旋转链表";

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;

        // 遍历计算个数
        ListNode node = root;
        int length = 0;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        // 将头尾连接起来
        node.next = root.next;
        // 找到要断开的地方
        k %= length;
        node = root;
        for (int i = 0; i < length - k; i++) {
            node = node.next;
        }
        // root指向新head
        // 断开新head的前驱结点
        root.next = node.next;
        node.next = null;
        return root.next;
    }
}

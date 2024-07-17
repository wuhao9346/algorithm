package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.Node;

/**
 * 138.随机链表的复制
 * TODO::测试提交
 */
public class CopyRandomList {

    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head.next != null && head.next.val == head.val) {
            return head.next;
        }
        Node newNode = new Node(head.val);
        newNode.next = head.next;
        head.next = newNode;

        newNode.random = copyRandomList(head.random);
        newNode.next = copyRandomList(newNode.next);
        return newNode;
    }
}

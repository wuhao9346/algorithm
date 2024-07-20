package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138.随机链表的复制
 */
public class CopyRandomList {
    public static final String NAME = "138.随机链表的复制";

    private final Map<Node, Node> mapper = new HashMap<>();

    /**
     * 借助字典映射+回溯实现
     */
    public Node copyRandomListLookBack(Node head) {
        if (head == null) {
            return null;
        }
        if (mapper.containsKey(head)) {
            return mapper.get(head);
        }
        Node newNode = new Node(head.val);
        mapper.put(head, newNode);

        newNode.random = copyRandomListLookBack(head.random);
        newNode.next = copyRandomListLookBack(head.next);
        return newNode;
    }

    /**
     * 巧妙的将新的节点插入旧节点之后，实现O(1)的空间复杂度
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }

        node = head;
        while (node != null) {
            Node newNode = node.next;
            newNode.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }

        Node newHead = head.next;
        node = head;
        while (node != null) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = node.next == null ? null : node.next.next;
            node = node.next;
        }
        return newHead;
    }
}

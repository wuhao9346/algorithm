package com.wuhao.algorithm.common.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    private static ListNode[] buildListNodeArray(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode[] listNodes = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            listNodes[i] = new ListNode(nums[i]);
            if (i > 0) {
                listNodes[i - 1].next = listNodes[i];
            }
        }
        return listNodes;
    }

    public static ListNode buildListNode(int[] nums) {
        ListNode[] listNodes = buildListNodeArray(nums);
        if (listNodes != null && listNodes.length > 0) {
            return listNodes[0];
        }
        return null;
    }

    public static ListNode buildListNode(int[] nums, int pos) {
        ListNode[] listNodes = buildListNodeArray(nums);
        if (listNodes != null && listNodes.length > 0) {
            if (pos >= 0 && pos < listNodes.length) {
                listNodes[listNodes.length - 1].next = listNodes[pos];
            }
            return listNodes[0];
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        Set<ListNode> set = new HashSet<>();
        List<ListNode> nodeList = new ArrayList<>();
        ListNode node = this;
        while (node != null && !set.contains(node)) {
            nodeList.add(node);
            set.add(node);
            node = node.next;
        }
        set.clear();
        List<ListNode> oNodeList = new ArrayList<>();
        node = listNode;
        while (node != null && !set.contains(node)) {
            oNodeList.add(node);
            set.add(node);
            node = node.next;
        }
        if (nodeList.size() != oNodeList.size()) {
            return false;
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).val != oNodeList.get(i).val) {
                return false;
            }
        }
        if (nodeList.size() > 0) {
            ListNode cycleNode = nodeList.get(nodeList.size() - 1).next;
            ListNode oCycleNode = oNodeList.get(nodeList.size() - 1).next;
            if (cycleNode == null & oCycleNode == null) {
                return true;
            }
            if (cycleNode == null || oCycleNode == null) {
                return false;
            }
            return cycleNode.val == oCycleNode.val;
        }
        return true;
    }

    @Override
    public String toString() {
        List<String> valueList = new ArrayList<>();
        Set<ListNode> set = new HashSet<>();
        ListNode node = this;
        while (node != null && !set.contains(node)) {
            valueList.add(String.valueOf(node.val));
            set.add(node);
            node = node.next;
        }
        return "[" + String.join(",", valueList) + (node == null ? "" : "|" + node.val) + "]";
    }
}

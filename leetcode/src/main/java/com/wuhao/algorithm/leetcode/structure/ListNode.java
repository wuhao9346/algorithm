package com.wuhao.algorithm.leetcode.structure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode[] buildListNodeArray(int[] nums) {
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

    public static void print(ListNode node) {
        while (node != null) {
            System.out.printf("%s\t", node.val);
            node = node.next;
        }
        System.out.println();
    }
}

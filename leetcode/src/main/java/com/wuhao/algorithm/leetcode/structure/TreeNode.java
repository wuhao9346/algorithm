package com.wuhao.algorithm.leetcode.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        List<String> valueList = new ArrayList<>();
        while ((node = queue.poll()) != null) {
            valueList.add(String.valueOf(node.val));
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println(String.join(",", valueList));
    }

    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length < 1) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] == null) {
                continue;
            }
            TreeNode left = null;
            if (i * 2 + 1 < nodes.length) {
                left = nodes[i * 2 + 1];
            }
            TreeNode right = null;
            if (i * 2 + 2 < nodes.length) {
                right = nodes[i * 2 + 2];
            }
            nodes[i] = new TreeNode(values[i], left, right);
        }
        return nodes[0];
    }
}

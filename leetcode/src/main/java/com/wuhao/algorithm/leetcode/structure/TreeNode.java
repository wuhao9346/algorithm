package com.wuhao.algorithm.leetcode.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left)
                && Objects.equals(right, treeNode.right)
                && Objects.equals(next, treeNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right, next);
    }

    @Override
    public String toString() {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(this);
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            if (node == null) {
                continue;
            }
            if (node.left != null) {
                while (nodeList.size() < 2 * i + 1) {
                    nodeList.add(null);
                }
                nodeList.add(node.left);
            }
            if (node.right != null) {
                while (nodeList.size() < 2 * i + 2) {
                    nodeList.add(null);
                }
                nodeList.add(node.right);
            }
        }
        return Arrays.toString(nodeList.stream()
                .map(treeNode -> treeNode == null ? null : treeNode.val)
                .toArray(Integer[]::new));
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 6});
        System.out.println(node);
    }
}

package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;

public class BSTIterator {
    public static final String NAME = "173.二叉搜索树迭代器";

    private TreeNode current;

    public BSTIterator(TreeNode root) {
        this.current = flatten(root);
    }

    private TreeNode flatten(TreeNode node) {
        TreeNode root = node;
        if (node.left != null) {
            root = flatten(node.left);
            node.left = null;
            TreeNode lastNode = root;
            while (lastNode.right != null) {
                lastNode = lastNode.right;
            }
            lastNode.right = node;
        }
        if (node.right != null) {
            node.right = flatten(node.right);
        }
        return root;
    }

    public int next() {
        int val = this.current.val;
        this.current = this.current.right;
        return val;
    }

    public boolean hasNext() {
        return this.current != null;
    }
}

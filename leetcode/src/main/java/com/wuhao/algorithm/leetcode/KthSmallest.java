package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Stack;

public class KthSmallest {
    public static final String NAME = "230.二叉搜索树中第K小的元素";

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return 0;
    }
}

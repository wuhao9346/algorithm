package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Stack;

/**
 * 530.二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    public static final String NAME = "530.二叉搜索树的最小绝对差";

    public int getMinimumDifference(TreeNode root) {
        int minimumDifference = Integer.MAX_VALUE;
        int preValue = -1;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }
            node = stack.pop();
            if (preValue != -1) {
                minimumDifference = Math.min(minimumDifference, node.val - preValue);
            }
            preValue = node.val;
            node = node.right;
        }
        return minimumDifference;
    }
}

package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

public class MaxPathSum {
    public static final String NAME = "124.二叉树中的最大路径和";
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int leftMaxGain = Math.max(maxGain(node.left), 0);
        int rightMaxGain = Math.max(maxGain(node.right), 0);
        maxPathSum = Math.max(maxPathSum, leftMaxGain + rightMaxGain + node.val);
        return node.val + Math.max(leftMaxGain, rightMaxGain);
    }
}

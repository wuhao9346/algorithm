package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.common.structure.TreeNode;

public class MaxPathSum {
    public static final String NAME = "NC6 二叉树中的最大路径和";

    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        recursion(root);
        return maxPathSum;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0, recursion(root.left));
        int rightMaxSum = Math.max(0, recursion(root.right));
        int sum = leftMaxSum + rightMaxSum + root.val;
        if (sum > maxPathSum) {
            maxPathSum = sum;
        }
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}

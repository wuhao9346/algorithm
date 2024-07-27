package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;

public class LowestCommonAncestor {
    public static final String NAME = "236.二叉树的最近公共祖先";
    private static TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftContain = dfs(root.left, p, q);
        boolean rightContain = dfs(root.right, p, q);
        boolean currentEqual = root.val == p.val || root.val == q.val;
        if (!leftContain && !rightContain) {
            return currentEqual;
        }
        if (leftContain && rightContain || currentEqual) {
            ancestor = root;
        }
        return true;
    }
}

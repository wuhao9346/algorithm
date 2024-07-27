package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;

public class CountNodes {
    public static final String NAME = "222.完全二叉树的节点个数";

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

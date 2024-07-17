package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST {

    public static final String NAME = "98.验证二叉搜索树";

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        Integer prevValue = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
                continue;
            }
            node = stack.pop();
            if (prevValue != null && node.val <= prevValue) {
                return false;
            }
            prevValue = node.val;
            node = node.right;
        }
        return true;
    }
}

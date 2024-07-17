package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;

/**
 * 98.验证二叉搜索树
 */
public class IsValidBST {
    public static void main(String[] args) {
        System.out.println(isValidBST(buildTree(new Integer[]{2, 1, 3})));
        System.out.println(isValidBST(buildTree(new Integer[]{5, 1, 4, null, null, 3, 6})));
    }

    public static boolean isValidBST(TreeNode root) {
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

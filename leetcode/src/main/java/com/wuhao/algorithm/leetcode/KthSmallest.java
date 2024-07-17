package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Stack;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;

/**
 * 230.二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public static void main(String[] args) {
        System.out.println(kthSmallest(buildTree(new Integer[]{3, 1, 4, null, 2}), 1));
        System.out.println(kthSmallest(buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
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

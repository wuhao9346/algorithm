package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.Stack;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;

/**
 * 530.二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        System.out.println(getMinimumDifference(buildTree(new Integer[]{4, 2, 6, 1, 3})));
        System.out.println(getMinimumDifference(buildTree(new Integer[]{1, 0, 48, null, null, 12, 49})));
        System.out.println(getMinimumDifference(buildTree(new Integer[]{236, 104, 701, null, 227, null, 911})));
        System.out.println(getMinimumDifference(buildTree(new Integer[]{0, null, 2236, null, null, 1277, 2776, null, null, null, null, 519})));
    }

    public static int getMinimumDifference(TreeNode root) {
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

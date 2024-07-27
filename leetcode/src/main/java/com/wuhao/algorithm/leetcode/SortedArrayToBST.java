package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;

public class SortedArrayToBST {
    public static final String NAME = "108. 将有序数组转换为二叉搜索树";

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildAVLTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildAVLTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = buildAVLTree(nums, left, middle - 1);
        node.right = buildAVLTree(nums, middle + 1, right);
        return node;
    }
}

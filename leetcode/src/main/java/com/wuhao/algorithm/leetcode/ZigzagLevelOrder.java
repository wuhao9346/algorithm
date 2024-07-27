package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static final String NAME = "103.二叉树的锯齿形层序遍历";

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean right = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> valueList = new LinkedList<>();
            result.add(valueList);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (right) {
                    valueList.addFirst(node.val);
                } else {
                    valueList.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            right = !right;
        }
        return result;
    }
}

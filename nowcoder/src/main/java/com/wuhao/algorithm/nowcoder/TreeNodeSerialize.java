package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.common.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNodeSerialize {
    public static final String NAME = "NC123 序列化二叉树";

    String Serialize(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        for (int i = 0; i < nodeList.size(); i++) {
            TreeNode node = nodeList.get(i);
            if (node == null) {
                continue;
            }
            if (node.left != null) {
                while (nodeList.size() < 2 * i + 1) {
                    nodeList.add(null);
                }
                nodeList.add(node.left);
            }
            if (node.right != null) {
                while (nodeList.size() < 2 * i + 2) {
                    nodeList.add(null);
                }
                nodeList.add(node.right);
            }
        }
        return nodeList.stream()
                .map(treeNode -> treeNode == null ? "" : String.valueOf(treeNode.val))
                .collect(Collectors.joining(","));
    }

    TreeNode Deserialize(String str) {
        Integer[] values = Arrays.stream(str.split(","))
                .map(t -> "".equals(t) ? null : Integer.valueOf(t))
                .toArray(Integer[]::new);
        if (values.length < 1) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            if (values[i] == null) {
                continue;
            }
            TreeNode left = null;
            if (i * 2 + 1 < nodes.length) {
                left = nodes[i * 2 + 1];
            }
            TreeNode right = null;
            if (i * 2 + 2 < nodes.length) {
                right = nodes[i * 2 + 2];
            }
            nodes[i] = new TreeNode(values[i]);
            nodes[i].left = left;
            nodes[i].right = right;
        }
        return nodes[0];
    }
}

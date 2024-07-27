package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 133.克隆图
 */
public class CloneGraph {
    public static final String NAME = "133.克隆图";

    public Map<Node, Node> cloneGraphMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node clonedNode = cloneGraphMap.getOrDefault(node, null);
        if (clonedNode != null) {
            return clonedNode;
        }
        clonedNode = new Node(node.val);
        cloneGraphMap.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }
}

package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.Node;

import java.util.HashMap;
import java.util.Map;

import static com.wuhao.algorithm.leetcode.structure.Node.buildGraph;

/**
 * 133.克隆图
 */
public class CloneGraph {

    public static void main(String[] args) {
        cloneGraph(buildGraph(new int[][]{
                new int[]{2, 4}, new int[]{1, 3}, new int[]{2, 4}, new int[]{1, 3}
        }));
        cloneGraph(buildGraph(new int[][]{
                new int[]{}
        }));
        cloneGraph(buildGraph(new int[][]{
        }));
    }

    private static Map<Node, Node> cloneGraphMap = new HashMap<>();

    public static Node cloneGraph(Node node) {
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

package com.wuhao.algorithm.common.structure;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node next;
    public Node random;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) {
            return null;
        }
        Node[] nodes = new Node[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < adjList.length; i++) {
            for (int j : adjList[i]) {
                nodes[i].neighbors.add(nodes[j - 1]);
            }
        }
        return nodes[0];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(val).append("->");
        if (next == null) {
            builder.append(next);
        } else {
            builder.append(next.val);
        }
        if (random != null) {
            builder.append("|").append(random.val);
        }
        builder.append("]");
        return builder.toString();
    }
}

package com.wuhao.algorithm.nowcoder;

import java.util.HashMap;
import java.util.Map;

public class TreeDiameter {
    public static final String NAME = "NC99 多叉树的直径";

    public int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        Map<Integer, Map<Integer, Integer>> graph = createGraph(n, Tree_edge, Edge_value);

        int[] result = new int[2];
        dfs(graph, Tree_edge[0].start, Tree_edge[0].start, 0, result);
        dfs(graph, result[1], result[1], 0, result);
        return result[0];
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> graph, int root, int prev, int path, int[] result) {
        Map<Integer, Integer> edges = graph.get(root);
        for (Map.Entry<Integer, Integer> entry : edges.entrySet()) {
            if (prev == entry.getKey()) {
                continue;
            }
            path += entry.getValue();
            if (path > result[0]) {
                result[0] = path;
                result[1] = entry.getKey();
            }
            dfs(graph, entry.getKey(), root, path, result);
            path -= entry.getValue();
        }
    }

    private Map<Integer, Map<Integer, Integer>> createGraph(int n, Interval[] treeEdge, int[] edgeValue) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            Interval interval = treeEdge[i];
            int edge = edgeValue[i];
            if (!graph.containsKey(interval.start)) {
                graph.put(interval.start, new HashMap<>());
            }
            graph.get(interval.start).put(interval.end, edge);
            if (!graph.containsKey(interval.end)) {
                graph.put(interval.end, new HashMap<>());
            }
            graph.get(interval.end).put(interval.start, edge);
        }
        return graph;
    }

    public static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }


}

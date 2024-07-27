package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.Node.buildGraph;

@DisplayName(CloneGraph.NAME)
class CloneGraphTest {
    private CloneGraph instance;

    public static Stream<int[][]> params() {
        return Stream.of(
                new int[][]{
                        new int[]{2, 4}, new int[]{1, 3}, new int[]{2, 4}, new int[]{1, 3}
                },
                new int[][]{
                        new int[]{}
                },
                new int[][]{
                }
        );
    }

    @BeforeEach
    void setUp() {
        instance = new CloneGraph();
        assertedSet = new HashSet<>();
    }

    @ParameterizedTest
    @MethodSource("params")
    void cloneGraph(int[][] adjList) {
        Node graph = buildGraph(adjList);
        assertCloneGraph(graph, instance.cloneGraph(graph));
    }

    private Set<Node> assertedSet;

    /**
     * 验证克隆图
     *
     * @param source 原图
     * @param target 克隆图
     * @return 验证通过
     */
    private boolean assertCloneGraph(Node source, Node target) {
        if (source == null && target == null) {
            return true;
        }

        if (source == null || target == null) {
            return false;
        }
        if (assertedSet.contains(source)) {
            return true;
        }
        if (source.neighbors.size() != target.neighbors.size()) {
            return false;
        }
        if (source.val != target.val) {
            return false;
        }
        for (int i = 0; i < source.neighbors.size(); i++) {
            if (source.neighbors.get(i).val != target.neighbors.get(i).val || source.neighbors.get(i).equals(target.neighbors.get(i))) {
                return false;
            }
        }
        assertedSet.add(source);
        for (int i = 0; i < source.neighbors.size(); i++) {
            if (!assertCloneGraph(source.neighbors.get(i), target.neighbors.get(i))) {
                return false;
            }
        }
        return true;
    }
}
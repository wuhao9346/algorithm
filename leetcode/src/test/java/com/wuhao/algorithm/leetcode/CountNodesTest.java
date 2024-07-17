package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.CountNodes;
import com.wuhao.algorithm.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;

@DisplayName(CountNodes.NAME)
class CountNodesTest {
    private final CountNodes instance = new CountNodes();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{1, 2, 3, 4, 5, 6}), 6),
                Arguments.arguments(buildTree(new Integer[]{}), 0),
                Arguments.arguments(buildTree(new Integer[]{1}), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void countNodes(TreeNode root, int count) {
        Assertions.assertEquals(count, instance.countNodes(root));
    }
}
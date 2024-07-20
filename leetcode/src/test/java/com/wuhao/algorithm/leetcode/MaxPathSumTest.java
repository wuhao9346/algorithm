package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;

@DisplayName(MaxPathSum.NAME)
class MaxPathSumTest {
    private MaxPathSum instance;

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{1, 2, 3}), 6),
                Arguments.arguments(buildTree(new Integer[]{-10, 9, 20, null, null, 15, 7}), 42)
        );
    }

    @BeforeEach
    void setUp() {
        instance = new MaxPathSum();
    }

    @ParameterizedTest
    @MethodSource("params")
    void maxPathSum(TreeNode root, int result) {
        Assertions.assertEquals(result, instance.maxPathSum(root));
    }
}
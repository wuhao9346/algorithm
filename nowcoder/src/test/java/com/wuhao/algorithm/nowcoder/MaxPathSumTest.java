package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(MaxPathSum.NAME)
class MaxPathSumTest {

    private final MaxPathSum instance = new MaxPathSum();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        TreeNode.buildTree(new Integer[]{1, 2, 3}),
                        6
                ), Arguments.arguments(
                        TreeNode.buildTree(new Integer[]{-20, 8, 20, null, null, 15, 6}),
                        41
                ), Arguments.arguments(
                        TreeNode.buildTree(new Integer[]{-2, null, -3}),
                        -2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void maxPathSum(TreeNode root, int result) {
        Assertions.assertEquals(result, instance.maxPathSum(root));
    }
}
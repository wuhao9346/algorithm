package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.TreeNode.buildTree;

@DisplayName(AverageOfLevels.NAME)
class AverageOfLevelsTest {
    private final AverageOfLevels instance = new AverageOfLevels();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}),
                        Arrays.asList(3.00000D, 14.50000D, 11.00000D)),
                Arguments.arguments(buildTree(new Integer[]{3, 9, 20, 15, 7}),
                        Arrays.asList(3.00000D, 14.50000D, 11.00000D))
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void averageOfLevels(TreeNode root, List<Double> result) {
        Assertions.assertEquals(result, instance.averageOfLevels(root));
    }
}
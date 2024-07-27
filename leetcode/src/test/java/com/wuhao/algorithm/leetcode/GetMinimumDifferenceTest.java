package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(GetMinimumDifference.NAME)
class GetMinimumDifferenceTest {
    private final GetMinimumDifference instance = new GetMinimumDifference();

    public static Stream<Arguments> params() {
        return Stream.of(
                arguments(buildTree(new Integer[]{4, 2, 6, 1, 3}),
                        1),
                arguments(buildTree(new Integer[]{1, 0, 48, null, null, 12, 49}),
                        1),
                arguments(buildTree(new Integer[]{236, 104, 701, null, 227, null, 911}),
                        9),
                arguments(buildTree(new Integer[]{0, null, 2236, null, null, 1277, 2776, null, null, null, null, 519}),
                        519)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void getMinimumDifference(TreeNode root, int result) {
        assertEquals(result, instance.getMinimumDifference(root));
    }
}
package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(SortedArrayToBST.NAME)
class SortedArrayToBSTTest {
    private final SortedArrayToBST instance = new SortedArrayToBST();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[]{-10, -3, 0, 5, 9},
                        TreeNode.buildTree(new Integer[]{0, -10, 5, null, -3, null, 9})
                ),
                Arguments.arguments(
                        new int[]{1, 3},
                        TreeNode.buildTree(new Integer[]{1, null, 3})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void sortedArrayToBST(int[] nums, TreeNode result) {
        Assertions.assertEquals(result, instance.sortedArrayToBST(nums));
    }
}
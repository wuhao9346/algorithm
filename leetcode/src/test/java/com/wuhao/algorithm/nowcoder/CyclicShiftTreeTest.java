package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.leetcode.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(CyclicShiftTree.NAME)
class CyclicShiftTreeTest {
    private final CyclicShiftTree instance = new CyclicShiftTree();

    public static Stream<Arguments> params() {
        return Stream.of(
//                Arguments.arguments(
//                        TreeNode.buildTree(new Integer[]{1, 2, 3, null, null, 4, 5}),
//                        1,
//                        TreeNode.buildTree(new Integer[]{1, 3, 2, null, 4, 5})
//                ),
//                Arguments.arguments(
//                        TreeNode.buildTree(new Integer[]{1, 2, 3, 4}),
//                        2,
//                        TreeNode.buildTree(new Integer[]{1, 2, 3, null, null, 4})
//                ),
                Arguments.arguments(
                        TreeNode.buildTree(new Integer[]{1, null, 3, null, null, 4, 5}),
                        1,
                        TreeNode.buildTree(new Integer[]{1, 3, null, 5, 4})
                ),
                Arguments.arguments(
                        TreeNode.buildTree(new Integer[]{5, 1, 7, null, 4, 6, null, 3, null, null, null, null, null, null, null, 2}),
                        2,
                        TreeNode.buildTree(new Integer[]{5, 1, 7, 6, null, null, 4, null, null, 3, null, null, null, 2})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void cyclicShiftTree(TreeNode root, int k, TreeNode result) {
        Assertions.assertEquals(result, instance.cyclicShiftTree(root, k));
    }
}
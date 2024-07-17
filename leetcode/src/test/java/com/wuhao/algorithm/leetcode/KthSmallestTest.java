package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(KthSmallest.NAME)
class KthSmallestTest {
    private final KthSmallest instance = new KthSmallest();

    public static Stream<Arguments> params() {
        return Stream.of(
                arguments(buildTree(new Integer[]{3, 1, 4, null, 2}), 1, 1),
                arguments(buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3, 3)
        );
    }

    @ParameterizedTest()
    @MethodSource("params")
    void kthSmallest(TreeNode root, int k, int result) {
        assertEquals(result, instance.kthSmallest(root, k));
    }
}
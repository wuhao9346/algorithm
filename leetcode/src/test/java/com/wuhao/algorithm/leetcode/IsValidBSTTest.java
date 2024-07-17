package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(IsValidBST.NAME)
class IsValidBSTTest {
    private final IsValidBST instance = new IsValidBST();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{2, 1, 3}), true),
                Arguments.arguments(buildTree(new Integer[]{5, 1, 4, null, null, 3, 6}), false)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void isValidBST(TreeNode root, boolean result) {
        assertEquals(result, instance.isValidBST(root));
    }
}
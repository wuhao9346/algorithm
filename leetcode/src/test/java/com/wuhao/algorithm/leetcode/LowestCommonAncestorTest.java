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

@DisplayName(LowestCommonAncestor.NAME)
class LowestCommonAncestorTest {
    private LowestCommonAncestor instance;

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}),
                        new TreeNode(5), new TreeNode(1),
                        3),
                Arguments.arguments(buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}),
                        new TreeNode(5), new TreeNode(4),
                        5),
                Arguments.arguments(buildTree(new Integer[]{1, 2}),
                        new TreeNode(1), new TreeNode(2),
                        1)
        );
    }

    @BeforeEach
    void setUp() {
        instance = new LowestCommonAncestor();
    }

    @ParameterizedTest
    @MethodSource("params")
    void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int result) {
        Assertions.assertEquals(result, instance.lowestCommonAncestor(root, p, q).val);
    }
}
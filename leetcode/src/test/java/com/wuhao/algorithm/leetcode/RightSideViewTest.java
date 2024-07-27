package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.TreeNode.buildTree;

@DisplayName(RightSideView.NAME)
class RightSideViewTest {
    private final RightSideView instance = new RightSideView();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{1, 2, 3, null, 5, null, 4}),
                        Arrays.asList(1, 3, 4)),
                Arguments.arguments(buildTree(new Integer[]{1, null, 3}),
                        Arrays.asList(1, 3)),
                Arguments.arguments(buildTree(new Integer[]{}),
                        Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void rightSideView(TreeNode root, List<Integer> result) {
        Assertions.assertEquals(result, instance.rightSideView(root));
    }
}
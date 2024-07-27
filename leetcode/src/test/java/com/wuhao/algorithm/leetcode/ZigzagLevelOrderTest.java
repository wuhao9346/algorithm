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

@DisplayName(ZigzagLevelOrder.NAME)
class ZigzagLevelOrderTest {
    private final ZigzagLevelOrder instance = new ZigzagLevelOrder();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}),
                        Arrays.asList(Collections.singletonList(3), Arrays.asList(20, 9), Arrays.asList(15, 7))),
                Arguments.arguments(buildTree(new Integer[]{1}),
                        Collections.singletonList(Collections.singletonList(1))),
                Arguments.arguments(buildTree(new Integer[]{}),
                        Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void zigzagLevelOrder(TreeNode root, List<List<Integer>> result) {
        Assertions.assertEquals(result, instance.zigzagLevelOrder(root));
    }
}
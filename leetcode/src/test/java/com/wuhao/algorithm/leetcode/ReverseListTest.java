package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.ListNode.buildListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(CloneGraph.NAME)
class ReverseListTest {
    private final ReverseList instance = new ReverseList();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        buildListNode(new int[]{1, 2, 3, 4, 5}),
                        buildListNode(new int[]{5, 4, 3, 2, 1})),
                Arguments.arguments(
                        buildListNode(new int[]{1, 2}),
                        buildListNode(new int[]{2, 1})),
                Arguments.arguments(
                        buildListNode(new int[]{}),
                        buildListNode(new int[]{}))
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void reverseList(ListNode node, ListNode result) {
        assertEquals(result, instance.reverseList(node));
    }
}
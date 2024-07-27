package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(RemoveNthFromEnd.NAME)
class RemoveNthFromEndTest {
    private final RemoveNthFromEnd instance = new RemoveNthFromEnd();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}),
                        2,
                        ListNode.buildListNode(new int[]{1, 2, 3, 5})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1}),
                        1,
                        ListNode.buildListNode(new int[]{})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2}),
                        1,
                        ListNode.buildListNode(new int[]{1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void removeNthFromEnd(ListNode head, int n, ListNode result) {
        Assertions.assertEquals(result, instance.removeNthFromEnd(head, n));
    }
}
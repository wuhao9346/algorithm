package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(ReverseBetween.NAME)
class ReverseBetweenTest {
    private final ReverseBetween instance = new ReverseBetween();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}),
                        2, 4,
                        ListNode.buildListNode(new int[]{1, 4, 3, 2, 5})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{5}),
                        1, 1,
                        ListNode.buildListNode(new int[]{5})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void reverseBetween(ListNode head, int left, int right, ListNode result) {
        Assertions.assertEquals(result, instance.reverseBetween(head, left, right));
    }
}
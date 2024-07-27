package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(RotateRight.NAME)
class RotateRightTest {
    private final RotateRight instance = new RotateRight();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}),
                        2,
                        ListNode.buildListNode(new int[]{4, 5, 1, 2, 3})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{0, 1, 2}),
                        4,
                        ListNode.buildListNode(new int[]{2, 0, 1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void rotateRight(ListNode head, int k, ListNode result) {
        Assertions.assertEquals(result, instance.rotateRight(head, k));
    }
}
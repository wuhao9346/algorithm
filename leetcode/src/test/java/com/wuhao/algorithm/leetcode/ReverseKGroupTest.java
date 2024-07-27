package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(ReverseKGroup.NAME)
class ReverseKGroupTest {
    private final ReverseKGroup instance = new ReverseKGroup();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}),
                        2,
                        ListNode.buildListNode(new int[]{2, 1, 4, 3, 5})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}),
                        3,
                        ListNode.buildListNode(new int[]{3, 2, 1, 4, 5})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void reverseKGroup(ListNode head, int k, ListNode result) {
        Assertions.assertEquals(result, instance.reverseKGroup(head, k));
    }
}
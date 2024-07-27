package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(Partition.NAME)
class PartitionTest {
    private final Partition instance = new Partition();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 4, 3, 2, 5, 2}),
                        3,
                        ListNode.buildListNode(new int[]{1, 2, 2, 4, 3, 5})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{2, 1}),
                        2,
                        ListNode.buildListNode(new int[]{1, 2})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 1}),
                        2,
                        ListNode.buildListNode(new int[]{1, 1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void partition(ListNode head, int x, ListNode result) {
        Assertions.assertEquals(result, instance.partition(head, x));
    }
}
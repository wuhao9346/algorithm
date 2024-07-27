package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(DeleteDuplicates.NAME)
class DeleteDuplicatesTest {
    private final DeleteDuplicates instance = new DeleteDuplicates();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 2, 3, 3, 4, 4, 5}),
                        ListNode.buildListNode(new int[]{1, 2, 5})
                ), Arguments.arguments(
                        ListNode.buildListNode(new int[]{1, 1, 1, 2, 3}),
                        ListNode.buildListNode(new int[]{2, 3})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void deleteDuplicates(ListNode head, ListNode result) {
        Assertions.assertEquals(result, instance.deleteDuplicates(head));
    }
}
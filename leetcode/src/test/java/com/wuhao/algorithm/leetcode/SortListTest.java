package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(SortList.NAME)
class SortListTest {
    private final SortList instance = new SortList();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{4, 2, 1, 3}),
                        ListNode.buildListNode(new int[]{1, 2, 3, 4})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{-1, 5, 3, 4, 0}),
                        ListNode.buildListNode(new int[]{-1, 0, 3, 4, 5})
                ),
                Arguments.arguments(
                        ListNode.buildListNode(new int[]{}),
                        ListNode.buildListNode(new int[]{})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void sortList(ListNode head, ListNode result) {
        Assertions.assertEquals(result, instance.sortList(head));
    }
}
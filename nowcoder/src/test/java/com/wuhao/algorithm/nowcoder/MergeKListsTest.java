package com.wuhao.algorithm.nowcoder;

import com.wuhao.algorithm.leetcode.structure.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(MergeKLists.NAME)
class MergeKListsTest {
    private final MergeKLists instance = new MergeKLists();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(
                                ListNode.buildListNode(new int[]{1, 2, 3}),
                                ListNode.buildListNode(new int[]{4, 5, 6, 7})
                        ),
                        ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7})
                ),
                Arguments.arguments(
                        Collections.emptyList(),
                        null
                ),
                Arguments.arguments(
                        Arrays.asList(
                                ListNode.buildListNode(new int[]{-7, -7, -6, -4, -4, 1, 1}),
                                ListNode.buildListNode(new int[]{-10, -9, -8, -7, -7, -5, -2, 2}),
                                ListNode.buildListNode(new int[]{-10, 3}),
                                ListNode.buildListNode(new int[]{}),
                                ListNode.buildListNode(new int[]{}),
                                ListNode.buildListNode(new int[]{-5, -4, -4, -4, -1, -1, 4}),
                                ListNode.buildListNode(new int[]{}),
                                ListNode.buildListNode(new int[]{-10, -5, -3, -1, 1, 2}),
                                ListNode.buildListNode(new int[]{-10, -9, -5, -4, -3, -1, -1})
                        ),
                        ListNode.buildListNode(new int[]{-10, -10, -10, -10, -9, -9, -8, -7, -7, -7, -7, -6, -5, -5, -5, -5, -4, -4, -4, -4, -4, -4, -3, -3, -2, -1, -1, -1, -1, -1, 1, 1, 1, 2, 2, 3, 4})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void mergeKLists(List<ListNode> lists, ListNode result) {
        Assertions.assertEquals(result, instance.mergeKLists(lists));
    }

    @ParameterizedTest
    @MethodSource("params")
    void mergeKLists2(List<ListNode> lists, ListNode result) {
        Assertions.assertEquals(result, instance.mergeKLists2(lists));
    }
}
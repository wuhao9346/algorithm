package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.ListNode.buildListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(HasCycle.NAME)
class HasCycleTest {
    private final HasCycle instance = new HasCycle();

    @ParameterizedTest
    @MethodSource("params")
    void hasCycle(ListNode head, boolean result) {
        assertEquals(instance.hasCycle(head), result);
    }

    public static Stream<Arguments> params() {
        return Stream.of(
                arguments(buildListNode(new int[]{3, 2, 0, -4}, 1), true),
                arguments(buildListNode(new int[]{1, 2}, 0), true),
                arguments(buildListNode(new int[]{1}, -1), false)
        );
    }
}
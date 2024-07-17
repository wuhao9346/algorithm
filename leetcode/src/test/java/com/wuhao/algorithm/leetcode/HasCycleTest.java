package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.leetcode.structure.ListNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.wuhao.algorithm.leetcode.structure.ListNode.buildListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HasCycleTest {
    private final HasCycle instance = new HasCycle();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @MethodSource("params")
    void hasCycle(int[] nums, int pos, boolean result) {
        ListNode head = buildListNode(nums, pos);
        assertEquals(instance.hasCycle(head), result);
    }

    public static Stream<Arguments> params() {
        return Stream.of(
                arguments(new int[]{3, 2, 0, -4}, 1, true),
                arguments(new int[]{1, 2}, 0, true),
                arguments(new int[]{1}, -1, false)
        );
    }
}
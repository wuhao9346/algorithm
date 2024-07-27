package com.wuhao.algorithm.leetcode;

import com.wuhao.algorithm.common.structure.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static com.wuhao.algorithm.common.structure.TreeNode.buildTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(BSTIterator.NAME)
class BSTIteratorTest {

    public static Stream<Arguments> params() {
        Function<BSTIterator, ?> next = BSTIterator::next;
        Function<BSTIterator, ?> hasNext = BSTIterator::hasNext;
        return Stream.of(
                Arguments.arguments(buildTree(new Integer[]{7, 3, 15, null, null, 9, 20}),
                        Arrays.asList(new AbstractMap.SimpleEntry<>(next, 3),
                                new AbstractMap.SimpleEntry<>(next, 7),
                                new AbstractMap.SimpleEntry<>(hasNext, true),
                                new AbstractMap.SimpleEntry<>(next, 9),
                                new AbstractMap.SimpleEntry<>(hasNext, true),
                                new AbstractMap.SimpleEntry<>(next, 15),
                                new AbstractMap.SimpleEntry<>(hasNext, true),
                                new AbstractMap.SimpleEntry<>(next, 20),
                                new AbstractMap.SimpleEntry<>(hasNext, false)))
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void test(TreeNode root, List<Map.Entry<Function<BSTIterator, ?>, ?>> actionList) {
        BSTIterator iterator = new BSTIterator(root);
        for (Map.Entry<Function<BSTIterator, ?>, ?> entry : actionList) {
            assertEquals(entry.getValue(), entry.getKey().apply(iterator));
        }
    }

}
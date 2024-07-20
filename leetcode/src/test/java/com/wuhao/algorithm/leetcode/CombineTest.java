package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(Combine.NAME)
class CombineTest {
    private final Combine instance = new Combine();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        4, 2,
                        Arrays.asList(
                                Arrays.asList(2, 4),
                                Arrays.asList(3, 4),
                                Arrays.asList(2, 3),
                                Arrays.asList(1, 2),
                                Arrays.asList(1, 3),
                                Arrays.asList(1, 4)
                        )
                ), Arguments.arguments(
                        1, 1,
                        Collections.singletonList(
                                Collections.singletonList(1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void combine(int n, int k, List<List<Integer>> result) {
        Assertions.assertEquals(new HashSet<>(result), new HashSet<>(instance.combine(n, k)));
    }
}
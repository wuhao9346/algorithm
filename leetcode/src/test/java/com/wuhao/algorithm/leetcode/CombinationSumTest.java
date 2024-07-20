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

@DisplayName(CombinationSum.NAME)
class CombinationSumTest {
    private final CombinationSum instance = new CombinationSum();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[]{2, 3, 6, 7},
                        7,
                        Arrays.asList(
                                Arrays.asList(2, 2, 3),
                                Collections.singletonList(7)
                        )
                ), Arguments.arguments(
                        new int[]{2, 3, 5},
                        8,
                        Arrays.asList(
                                Arrays.asList(2, 2, 2, 2),
                                Arrays.asList(2, 3, 3),
                                Arrays.asList(3, 5)
                        )
                ), Arguments.arguments(
                        new int[]{2},
                        1,
                        Collections.emptyList()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void combinationSum(int[] candidates, int target, List<List<Integer>> result) {
        Assertions.assertEquals(new HashSet<>(result), new HashSet<>(instance.combinationSum(candidates, target)));
    }
}
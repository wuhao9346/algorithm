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

@DisplayName(Permute.NAME)
class PermuteTest {
    private final Permute instance = new Permute();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[]{1, 2, 3},
                        Arrays.asList(
                                Arrays.asList(1, 2, 3),
                                Arrays.asList(1, 3, 2),
                                Arrays.asList(2, 1, 3),
                                Arrays.asList(2, 3, 1),
                                Arrays.asList(3, 1, 2),
                                Arrays.asList(3, 2, 1)
                        )
                ), Arguments.arguments(
                        new int[]{0, 1},
                        Arrays.asList(
                                Arrays.asList(0, 1),
                                Arrays.asList(1, 0)
                        )
                ), Arguments.arguments(
                        new int[]{1},
                        Collections.singletonList(
                                Collections.singletonList(1)
                        )
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void permute(int[] nums, List<List<Integer>> result) {
        Assertions.assertEquals(new HashSet<>(result), new HashSet<>(instance.permute(nums)));
    }
}
package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(TrailingZeroes.NAME)
class TrailingZeroesTest {
    private final TrailingZeroes instance = new TrailingZeroes();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(3, 0),
                Arguments.arguments(5, 1),
                Arguments.arguments(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void trailingZeroes(int n, int result) {
        Assertions.assertEquals(result, instance.trailingZeroes(n));
    }
}
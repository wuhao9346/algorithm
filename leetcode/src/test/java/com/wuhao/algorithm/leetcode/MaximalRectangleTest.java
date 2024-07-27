package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(MaximalRectangle.NAME)
class MaximalRectangleTest {

    private final MaximalRectangle instance = new MaximalRectangle();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new String[]{
                                "1"
                        }, 1
                ), Arguments.arguments(
                        new String[]{
                                "11",
                                "01"
                        }, 2
                ), Arguments.arguments(
                        new String[]{
                                "00",
                                "00"
                        }, 0
                ), Arguments.arguments(
                        new String[]{
                                "10100",
                                "11110",
                                "11111",
                                "10010"
                        }, 8
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void maximalRectangle(String[] matrix, int result) {
        Assertions.assertEquals(result, instance.maximalRectangle(matrix));
    }
}
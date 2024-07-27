package com.wuhao.algorithm.nowcoder;

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
                        new int[][]{
                                new int[]{1}
                        }, 1
                ), Arguments.arguments(
                        new int[][]{
                                new int[]{1, 1},
                                new int[]{0, 1}
                        }, 2
                ), Arguments.arguments(
                        new int[][]{
                                new int[]{0, 0},
                                new int[]{0, 0}
                        }, 0
                ), Arguments.arguments(
                        new int[][]{
                                new int[]{1, 0, 1, 0, 0},
                                new int[]{1, 1, 1, 1, 0},
                                new int[]{1, 1, 1, 1, 1},
                                new int[]{1, 0, 0, 1, 0}
                        }, 8
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void maximalRectangle(int[][] matrix, int result) {
        Assertions.assertEquals(result, instance.maximalRectangle(matrix));
    }
}
package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(SnakesAndLadders.NAME)
class SnakesAndLaddersTest {
    private final SnakesAndLadders instance = new SnakesAndLadders();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[][]{
                                new int[]{-1, -1, -1, -1, -1, -1},
                                new int[]{-1, -1, -1, -1, -1, -1},
                                new int[]{-1, -1, -1, -1, -1, -1},
                                new int[]{-1, 35, -1, -1, 13, -1},
                                new int[]{-1, -1, -1, -1, -1, -1},
                                new int[]{-1, 15, -1, -1, -1, -1}
                        }, 4
                ),
                Arguments.arguments(
                        new int[][]{
                                new int[]{-1, -1},
                                new int[]{-1, 3}
                        }, 1
                ),
                Arguments.arguments(
                        new int[][]{
                                new int[]{1, 1, -1},
                                new int[]{1, 1, 1},
                                new int[]{-1, 1, 1}
                        }, -1
                ),
                Arguments.arguments(
                        new int[][]{
                                new int[]{-1, -1, -1, 46, 47, -1, -1, -1},
                                new int[]{51, -1, -1, 63, -1, 31, 21, -1},
                                new int[]{-1, -1, 26, -1, -1, 38, -1, -1},
                                new int[]{-1, -1, 11, -1, 14, 23, 56, 57},
                                new int[]{11, -1, -1, -1, 49, 36, -1, 48},
                                new int[]{-1, -1, -1, 33, 56, -1, 57, 21},
                                new int[]{-1, -1, -1, -1, -1, -1, 2, -1},
                                new int[]{-1, -1, -1, 8, 3, -1, 6, 56}
                        }, 4
                ),
                Arguments.arguments(
                        new int[][]{
                                new int[]{-1, -1, -1},
                                new int[]{-1, 9, 8},
                                new int[]{-1, 8, 9}
                        }, 1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void snakesAndLadders(int[][] board, int result) {
        assertEquals(result, instance.snakesAndLadders(board));
    }
}
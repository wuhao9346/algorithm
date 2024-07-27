package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(LFU.NAME)
class LFUTest {
    private final LFU instance = new LFU();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 2, 2},
                                new int[]{1, 3, 2},
                                new int[]{1, 2, 4},
                                new int[]{1, 3, 5},
                                new int[]{2, 2},
                                new int[]{1, 4, 4},
                                new int[]{2, 1}
                        },
                        3,
                        new int[]{4, -1}
                ),
                Arguments.arguments(
                        new int[][]{
                                new int[]{1, 1, 1},
                                new int[]{1, 2, 2},
                                new int[]{1, 3, 3},
                                new int[]{1, 4, 4},
                                new int[]{2, 4},
                                new int[]{2, 3},
                                new int[]{2, 2},
                                new int[]{2, 1},
                                new int[]{1, 5, 5},
                                new int[]{2, 4}
                        },
                        4,
                        new int[]{4, 3, 2, 1, -1}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void LFU(int[][] operators, int k, int[] result) {
        Assertions.assertArrayEquals(result, instance.LFU(operators, k));
    }
}
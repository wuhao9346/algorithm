package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(MaxInWindows.NAME)
class MaxInWindowsTest {
    private final MaxInWindows instance = new MaxInWindows();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new int[]{2, 3, 4, 2, 6, 2, 5, 1},
                        3,
                        Arrays.asList(4, 4, 6, 6, 6, 5)
                ),
                Arguments.arguments(
                        new int[]{9, 10, 9, -7, -3, 8, 2, -6},
                        5,
                        Arrays.asList(10, 10, 9, 8)
                ),
                Arguments.arguments(
                        new int[]{1, 2, 3, 4},
                        5,
                        Collections.emptyList()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void maxInWindows(int[] num, int size, List<Integer> result) {
        Assertions.assertEquals(result, instance.maxInWindows(num, size));
    }
}
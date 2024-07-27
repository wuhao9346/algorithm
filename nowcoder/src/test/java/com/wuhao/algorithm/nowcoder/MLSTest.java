package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(MLS.NAME)
class MLSTest {
    private final MLS instance = new MLS();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.arguments(new int[]{1, 1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void MLS(int[] arr, int result) {
        Assertions.assertEquals(result, instance.MLS(arr));
    }
}
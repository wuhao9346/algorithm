package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(MinEditCost.NAME)
class MinEditCostTest {
    private final MinEditCost instance = new MinEditCost();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments("abc", "adc", 5, 3, 2, 2),
                Arguments.arguments("abc", "adc", 5, 3, 100, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void minEditCost(String str1, String str2, int ic, int dc, int rc, int result) {
        Assertions.assertEquals(result, instance.minEditCost(str1, str2, ic, dc, rc));
    }
}
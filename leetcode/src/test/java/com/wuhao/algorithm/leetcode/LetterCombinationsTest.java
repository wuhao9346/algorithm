package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(LetterCombinations.NAME)
class LetterCombinationsTest {

    private final LetterCombinations instance = new LetterCombinations();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        "23",
                        Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
                ), Arguments.arguments(
                        "",
                        Collections.emptyList()
                ), Arguments.arguments(
                        "2",
                        Arrays.asList("a", "b", "c")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void letterCombinations(String digits, List<String> result) {
        Assertions.assertEquals(result, instance.letterCombinations(digits));
    }
}
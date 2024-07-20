package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(MinMutation.NAME)
class MinMutationTest {
    private final MinMutation instance = new MinMutation();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        "AACCGGTT", "AACCGGTA",
                        new String[]{"AACCGGTA"},
                        1
                ),
                Arguments.arguments(
                        "AACCGGTT", "AAACGGTA",
                        new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"},
                        2
                ),
                Arguments.arguments(
                        "AAAAACCC", "AACCCCCC",
                        new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"},
                        3
                ),
                Arguments.arguments(
                        "hit", "cog",
                        new String[]{"hot", "dot", "dog", "lot", "log", "cog"},
                        4
                )
                ,
                Arguments.arguments(
                        "hit", "cog",
                        new String[]{"hot", "dot", "dog", "lot", "log"},
                        0
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void minMutation(String startGene, String endGene, String[] bank, int result) {
        Assertions.assertEquals(result, instance.minMutation(startGene, endGene, bank));
    }
}
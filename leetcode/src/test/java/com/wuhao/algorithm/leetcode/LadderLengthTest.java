package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(LadderLength.NAME)
class LadderLengthTest {

    private final LadderLength instance = new LadderLength();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"), 5),
                Arguments.arguments("hit", "cog",
                        Arrays.asList("hot", "dot", "dog", "lot", "log"), 0),
                Arguments.arguments("a", "c",
                        Arrays.asList("a", "b", "c"), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void ladderLength(String beginWord, String endWord, List<String> wordList, int result) {
        Assertions.assertEquals(result, instance.ladderLength(beginWord, endWord, wordList));
    }
}
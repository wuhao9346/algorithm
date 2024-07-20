package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

@DisplayName(FindWords.NAME)
class FindWordsTest {
    private final FindWords instance = new FindWords();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        new char[][]{
                                new char[]{'o', 'a', 'a', 'n'},
                                new char[]{'e', 't', 'a', 'e'},
                                new char[]{'i', 'h', 'k', 'r'},
                                new char[]{'i', 'f', 'l', 'v'}
                        },
                        new String[]{"oath", "pea", "eat", "rain"},
                        Arrays.asList("eat", "oath")
                ),
                Arguments.arguments(
                        new char[][]{
                                new char[]{'a', 'b'},
                                new char[]{'c', 'd'}
                        },
                        new String[]{"abcb"},
                        Collections.emptyList()
                ), Arguments.arguments(
                        new char[][]{
                                new char[]{'a', 'b', 'c', 'e'},
                                new char[]{'x', 'x', 'c', 'd'},
                                new char[]{'x', 'x', 'b', 'a'}
                        },
                        new String[]{"abc", "abcd"},
                        Arrays.asList("abc", "abcd")
                ), Arguments.arguments(
                        new char[][]{
                                new char[]{'a', 'b', 'c'},
                                new char[]{'a', 'e', 'd'},
                                new char[]{'a', 'f', 'g'}
                        },
                        new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"},
                        Arrays.asList("abcdefg", "befa", "eaabcdgfa", "gfedcbaaa")
                ), Arguments.arguments(
                        new char[][]{
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
                                new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}
                        },
                        new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"},
                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
                )


        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void findWords(char[][] board, String[] words, List<String> result) {
        Assertions.assertEquals(new HashSet<>(result), new HashSet<>(instance.findWords(board, words)));
    }
}
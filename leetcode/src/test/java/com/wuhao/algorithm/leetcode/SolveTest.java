package com.wuhao.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(Solve.NAME)
class SolveTest {
    private final Solve instance = new Solve();

    public static Stream<Arguments> params() {
        return Stream.of(
                arguments(new char[][]{
                        new char[]{'X', 'X', 'X', 'X'},
                        new char[]{'X', 'O', 'O', 'X'},
                        new char[]{'X', 'X', 'O', 'X'},
                        new char[]{'X', 'O', 'X', 'X'}
                }, new char[][]{
                        new char[]{'X', 'X', 'X', 'X'},
                        new char[]{'X', 'X', 'X', 'X'},
                        new char[]{'X', 'X', 'X', 'X'},
                        new char[]{'X', 'O', 'X', 'X'}
                }),
                arguments(new char[][]{
                        new char[]{'X'}
                }, new char[][]{
                        new char[]{'X'}
                }),
                arguments(new char[][]{
                                new char[]{'O', 'O'},
                                new char[]{'O', 'O'},
                        },
                        new char[][]{
                                new char[]{'O', 'O'},
                                new char[]{'O', 'O'},
                        })
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void solve(char[][] board, char[][] result) {
        instance.solve(board);
        Assertions.assertArrayEquals(result, board);
    }
}
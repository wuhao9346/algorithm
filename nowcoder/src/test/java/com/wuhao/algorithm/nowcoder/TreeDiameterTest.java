package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName(TreeDiameter.NAME)
class TreeDiameterTest {
    private final TreeDiameter instance = new TreeDiameter();

    public static Stream<Arguments> params() {
        return Stream.of(
                Arguments.arguments(
                        6,
                        new TreeDiameter.Interval[]{
                                new TreeDiameter.Interval(0, 1),
                                new TreeDiameter.Interval(1, 5),
                                new TreeDiameter.Interval(1, 2),
                                new TreeDiameter.Interval(2, 3),
                                new TreeDiameter.Interval(2, 4),
                        },
                        new int[]{3, 4, 2, 1, 5},
                        11
                ),
                Arguments.arguments(
                        2,
                        new TreeDiameter.Interval[]{
                                new TreeDiameter.Interval(0, 1),
                                new TreeDiameter.Interval(1, 2)
                        },
                        new int[]{1},
                        1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("params")
    void solve(int n, TreeDiameter.Interval[] treeEdge, int[] edgeValue, int result) {
        Assertions.assertEquals(result, instance.solve(n, treeEdge, edgeValue));
    }
}
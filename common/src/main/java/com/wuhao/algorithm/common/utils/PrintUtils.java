package com.wuhao.algorithm.common.utils;

import java.util.Arrays;

public class PrintUtils {
    public static void print(char[][] board) {
        System.out.println(Arrays.toString(Arrays.stream(board).map(Arrays::toString).toArray(String[]::new)));
    }
}

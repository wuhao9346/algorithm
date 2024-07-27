package com.wuhao.algorithm.leetcode;

public class TrailingZeroes {
    public static final String NAME = "172. 阶乘后的零";

    public int trailingZeroes(int n) {
        int result = 0;
        while (n != 0) {
            n /= 5;
            result += n;
        }
        return result;
    }
}

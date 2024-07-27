package com.wuhao.algorithm.nowcoder;

import java.util.HashSet;
import java.util.Set;

public class MLS {
    public static final String NAME = "NC95 数组中的最长连续子序列";

    public int MLS(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int maxLength = 0;
        for (Integer value : set) {
            if (set.contains(value - 1)) {
                continue;
            }

            int current = value;
            int length = 1;
            while (set.contains(++current)) {
                length++;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}

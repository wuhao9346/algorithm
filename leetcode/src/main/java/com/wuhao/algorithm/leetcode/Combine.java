package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combine {
    public static final String NAME = "77.组合";

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Integer[] nums = new Integer[k];
        backtrack(n, nums, 0, result);
        return result;
    }

    private void backtrack(int n, Integer[] nums, int i, List<List<Integer>> result) {
        for (int j = i == 0 ? 1 : nums[i - 1] + 1; j <= n; j++) {
            nums[i] = j;
            if (i + 1 < nums.length) {
                backtrack(n, nums, i + 1, result);
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums)));
            }
        }
    }
}

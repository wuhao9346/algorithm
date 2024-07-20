package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static final String NAME = "39.组合总和";

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        combinationSum(candidates, 0, target, combination, result);
        return result;
    }

    private void combinationSum(int[] candidates, int i, int target, LinkedList<Integer> combination, List<List<Integer>> result) {
        for (; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate > target) {
                continue;
            }
            combination.addLast(candidate);
            if (candidate == target) {
                result.add(new ArrayList<>(combination));
            } else {
                combinationSum(candidates, i, target - candidate, combination, result);
            }
            combination.removeLast();
        }
    }
}

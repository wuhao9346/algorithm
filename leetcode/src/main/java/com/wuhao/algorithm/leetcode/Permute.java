package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static final String NAME = "46.全排列";

    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        Integer[] target = new Integer[nums.length];
        bfs(target, 0, nums, flag, result);
        return result;
    }

    private void bfs(Integer[] target, int i, int[] nums, boolean[] flag, List<List<Integer>> result) {
        for (int j = 0; j < nums.length; j++) {
            if (flag[j]) {
                continue;
            }
            target[i] = nums[j];
            flag[j] = true;
            if (i + 1 < target.length) {
                bfs(target, i + 1, nums, flag, result);
            } else {
                result.add(new ArrayList<>(Arrays.asList(target)));
            }
            flag[j] = false;
        }
    }
}

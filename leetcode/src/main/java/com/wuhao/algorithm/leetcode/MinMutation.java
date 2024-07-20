package com.wuhao.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinMutation {
    public static final String NAME = "433.最小基因变化";

    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] flag = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.remove();
                for (int j = 0; j < bank.length; j++) {
                    if (!flag[j] && isValid(gene, bank[j])) {
                        if (bank[j].equals(endGene)) {
                            return count + 1;
                        }
                        flag[j] = true;
                        queue.add(bank[j]);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValid(String start, String end) {
        int length = start.length();
        char[] startChars = start.toCharArray();
        char[] endChars = end.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (startChars[i] != endChars[i]) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}

package com.wuhao.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public static final String NAME = "909.蛇梯棋";

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] flag = new boolean[target + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        flag[1] = true;
        int num = -1;
        while (!queue.isEmpty()) {
            num++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int sn = queue.remove();
                for (int j = sn + 1; j <= sn + 6 && j <= target; j++) {
                    if (j == target) {
                        return num + 1;
                    }
                    int x = n - 1 - (j - 1) / n;
                    int y = (j - 1) % n;
                    if ((j - 1) / n % 2 == 1) {
                        y = n - 1 - y;
                    }
                    int value = board[x][y];
                    if (value == target) {
                        return num + 1;
                    }
                    if (flag[j]) {
                        continue;
                    }
                    flag[j] = true;
                    queue.add(value == -1 ? j : value);
                }
            }
        }
        return -1;
    }

    private int[] getLocation(int value, int n) {
        value = value - 1;
        int x = value / n;
        int y = value - 1 % n;
        if ((value - 1) / n % 2 == 1) {
            y = n - 1 - y;
        }
        x = n - 1 - (value - 1) / n;
        return new int[]{x, y};
    }
}

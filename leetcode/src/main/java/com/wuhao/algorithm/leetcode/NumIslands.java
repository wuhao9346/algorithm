package com.wuhao.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static final String NAME = "200.岛屿数量";

    public int numIslandsBFS(char[][] grid) {
        return numIslands(grid, this::bfs);
    }

    public int numIslandsDFS(char[][] grid) {
        return numIslands(grid, this::dfs);
    }

    private int numIslands(char[][] grid, FSAction fsAction) {
        if (grid.length < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fsAction.fs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

    private void bfs(int i, int j, char[][] grid) {
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        Queue<int[]> deque = new LinkedList<>();
        grid[i][j] = '0';
        deque.add(new int[]{i, j});
        while (!deque.isEmpty()) {
            int[] point = deque.remove();
            int rowIndex = point[0];
            int columnIndex = point[1];
            if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] == '1') {
                grid[rowIndex - 1][columnIndex] = '0';
                deque.add(new int[]{rowIndex - 1, columnIndex});
            }
            if (rowIndex + 1 < rowSize && grid[rowIndex + 1][columnIndex] == '1') {
                grid[rowIndex + 1][columnIndex] = '0';
                deque.add(new int[]{rowIndex + 1, columnIndex});
            }
            if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] == '1') {
                grid[rowIndex][columnIndex - 1] = '0';
                deque.add(new int[]{rowIndex, columnIndex - 1});
            }
            if (columnIndex + 1 < columnSize && grid[rowIndex][columnIndex + 1] == '1') {
                grid[rowIndex][columnIndex + 1] = '0';
                deque.add(new int[]{rowIndex, columnIndex + 1});
            }
        }
    }

    @FunctionalInterface
    private interface FSAction {
        void fs(int i, int j, char[][] grid);
    }
}

package com.wuhao.algorithm.leetcode;

/**
 * 130.被围绕的区域
 */
public class Solve {
    public static final String NAME = "130.被围绕的区域";

    public void solve(char[][] board) {
        int rowSize = board.length;
        int columnSize = board[0].length;
        for (int i = 0; i < rowSize; i++) {
            if (board[i][0] == 'O') {
                solveDFS(i, 0, board);
            }
            if (board[i][columnSize - 1] == 'O') {
                solveDFS(i, columnSize - 1, board);
            }
        }
        for (int j = 0; j < columnSize; j++) {
            if (board[0][j] == 'O') {
                solveDFS(0, j, board);
            }
            if (board[rowSize - 1][j] == 'O') {
                solveDFS(rowSize - 1, j, board);
            }
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solveDFS(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        solveDFS(i - 1, j, board);
        solveDFS(i + 1, j, board);
        solveDFS(i, j - 1, board);
        solveDFS(i, j + 1, board);
    }
}

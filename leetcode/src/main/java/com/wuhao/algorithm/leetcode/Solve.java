package com.wuhao.algorithm.leetcode;

import static com.wuhao.algorithm.leetcode.utils.PrintUtils.print;

/**
 * 130.被围绕的区域
 */
public class Solve {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}
        };
        solve(board);
        print(board);

        board = new char[][]{
                new char[]{'X'}
        };
        solve(board);
        print(board);

        board = new char[][]{
                new char[]{'O', 'O'},
                new char[]{'O', 'O'},
        };
        solve(board);
        print(board);
    }

    public static void solve(char[][] board) {
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

    private static void solveDFS(int i, int j, char[][] board) {
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

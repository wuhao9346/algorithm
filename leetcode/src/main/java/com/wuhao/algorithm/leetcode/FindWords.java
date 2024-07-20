package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

// TODO: 当前代码超时，所有word构建前缀树，然后对二维数组深搜
public class FindWords {
    public static final String NAME = "212.单词搜索II";

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        Node[][] nodes = new Node[n][m];

        for (String word : words) {
            if (findWords(board, word, nodes)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean findWords(char[][] board, String word, Node[][] nodes) {
        int n = board.length;
        int m = board[0].length;
        char firstChar = word.charAt(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == firstChar) {
                    if (nodes[i][j] == null) {
                        nodes[i][j] = buildTree(i * m + j, board);
                    }
                    Node node = search(nodes[i][j], word);
                    if (node != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private Node buildTree(int start, char[][] board) {
        int n = board.length;
        int m = board[0].length;

        Node root = new Node();
        Node node = new Node();
        root.nodes[board[start / m][start % m] - 'a'] = node;

        Stack<Integer> stack = new Stack<>();
        Stack<Set<Integer>> flagStack = new Stack<>();
        Set<Integer> flagSet = new HashSet<>();
        Stack<Node> nodeStack = new Stack<>();

        stack.push(start);
        nodeStack.push(node);
        flagStack.push(new HashSet<>());
        flagSet.add(start);

        List<Function<Integer, Integer>> nextSuppliers = Arrays.asList(
                (base) -> (base > 0 && base % m > (base - 1) % m) ? base - 1 : null,
                (base) -> (base < n * m - 1 && (base + 1) % m > base % m) ? base + 1 : null,
                (base) -> (base - m) >= 0 ? base - m : null,
                (base) -> (base + m) < n * m ? base + m : null
        );
        while (!stack.isEmpty()) {
            Integer base = stack.peek();
            Integer nextValue = null;
            do {
                for (Function<Integer, Integer> nextSupplier : nextSuppliers) {
                    nextValue = nextSupplier.apply(base);
                    if (nextValue == null) {
                        continue;
                    }
                    if (flagSet.contains(nextValue) || flagStack.peek().contains(nextValue)) {
                        nextValue = null;
                        continue;
                    }
                    flagSet.add(nextValue);
                    stack.add(nextValue);
                    if (nodeStack.peek().nodes[board[nextValue / m][nextValue % m] - 'a'] == null) {
                        nodeStack.peek().nodes[board[nextValue / m][nextValue % m] - 'a'] = new Node();
                    }
                    nodeStack.push(nodeStack.peek().nodes[board[nextValue / m][nextValue % m] - 'a']);
                    flagStack.peek().add(nextValue);
                    flagStack.add(new HashSet<>());
                    break;
                }
                base = nextValue;
            } while (base != null);

            nodeStack.pop();
            flagSet.remove(stack.pop());
            flagStack.pop();
        }

        return root;
    }

    private Node search(Node node, String word) {
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if ((node = node.nodes[ch - 'a']) == null) {
                return null;
            }
        }
        return node;
    }

    private static class Node {
        Node[] nodes = new Node[26];
    }
}

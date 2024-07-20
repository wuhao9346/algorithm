package com.wuhao.algorithm.leetcode;

class Trie {

    public static final String NAME = "208.实现 Trie (前缀树)";

    private final Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node node = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (node.nodes[ch - 'a'] == null) {
                node.nodes[ch - 'a'] = new Node();
            }
            node = node.nodes[ch - 'a'];
        }
        node.count++;
    }

    public boolean search(String word) {
        Node node = searchNode(word);
        return node != null && node.count > 0;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String prefix) {
        Node node = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            if ((node = node.nodes[ch - 'a']) == null) {
                return null;
            }
        }
        return node;
    }

    private static class Node {
        int count = 0;
        Node[] nodes = new Node[26];
    }
}
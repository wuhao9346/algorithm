package com.wuhao.algorithm.leetcode;

class WordDictionary {
    public static final String NAME = "211.添加与搜索单词-数据结构设计";

    private final Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
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
        Node node = searchNode(root, word.toCharArray(), 0);
        return node != null;
    }

    private Node searchNode(Node root, char[] chars, int beginIndex) {
        if (root == null) {
            return null;
        }
        if (beginIndex == chars.length) {
            return root.count > 0 ? root : null;
        }
        if (chars[beginIndex] == '.') {
            for (Node node : root.nodes) {
                if (node == null) {
                    continue;
                }
                Node targetNode = searchNode(node, chars, beginIndex + 1);
                if (targetNode != null) {
                    return targetNode;
                }
            }
            return null;
        }
        return searchNode(root.nodes[chars[beginIndex] - 'a'], chars, beginIndex + 1);
    }

    private static class Node {
        int count = 0;
        Node[] nodes = new Node[26];
    }
}
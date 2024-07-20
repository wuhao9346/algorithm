package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LadderLength {
    public static final String NAME = "127.单词接龙";

    /**
     * 单词接龙
     * 使用虚拟点组建图，然后双向BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordMapper = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.add(endWord);
        for (String word : wordSet) {
            List<String> mapperList = new ArrayList<>();
            wordMapper.put(word, mapperList);
            char[] wordChars = word.toCharArray();
            for (int i = 0; i < wordChars.length; i++) {
                char temp = wordChars[i];
                wordChars[i] = '*';
                String s = String.valueOf(wordChars);
                mapperList.add(s);

                List<String> list = new ArrayList<>();
                list.add(word);
                wordMapper.merge(s, list, (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                });

                wordChars[i] = temp;
            }
        }

        Set<String> beginSet = new HashSet<>();
        Queue<String> beginQueue = new LinkedList<>();
        beginQueue.add(beginWord);
        beginSet.add(beginWord);
        int beginCount = 0;

        Set<String> endSet = new HashSet<>();
        Queue<String> endQueue = new LinkedList<>();
        endQueue.add(endWord);
        endSet.add(endWord);
        int endCount = 0;
        while (!beginQueue.isEmpty()) {
            beginCount++;
            int size = beginQueue.size();
            for (int i = 0; i < size; i++) {
                String word = beginQueue.remove();
                List<String> mapperWordList = wordMapper.get(word);
                if (mapperWordList == null || mapperWordList.isEmpty()) {
                    continue;
                }
                for (String mapperWord : mapperWordList) {
                    if (beginSet.contains(mapperWord)) {
                        continue;
                    }
                    if (endSet.contains(mapperWord)) {
                        return (beginCount + endCount) / 2 + 1;
                    }
                    beginSet.add(mapperWord);
                    beginQueue.add(mapperWord);
                }
            }

            endCount++;
            size = endQueue.size();
            for (int i = 0; i < size; i++) {
                String word = endQueue.remove();
                List<String> mapperWordList = wordMapper.get(word);
                if (mapperWordList == null || mapperWordList.isEmpty()) {
                    continue;
                }
                for (String mapperWord : mapperWordList) {
                    if (endSet.contains(mapperWord)) {
                        continue;
                    }
                    if (beginSet.contains(mapperWord)) {
                        return (beginCount + endCount) / 2 + 1;
                    }
                    endSet.add(mapperWord);
                    endQueue.add(mapperWord);
                }
            }
        }
        return 0;
    }
}

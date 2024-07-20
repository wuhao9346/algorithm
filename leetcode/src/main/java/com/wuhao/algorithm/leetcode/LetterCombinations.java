package com.wuhao.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinations {
    public static final String NAME = "17.电话号码的字母组合";

    private final char[][] dict = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return Collections.emptyList();
        }
        List<String> letterCombinations = new ArrayList<>();
        char[] str = new char[digits.length()];
        backtrack(digits, str, 0, letterCombinations);
        return letterCombinations;
    }

    private void backtrack(String digits, char[] str, int i, List<String> letterCombinations) {
        char num = digits.charAt(i);
        char[] chars = dict[num - '2'];
        for (char ch : chars) {
            str[i] = ch;
            if (i + 1 < str.length) {
                backtrack(digits, str, i + 1, letterCombinations);
            } else {
                letterCombinations.add(new String(str));
            }
        }
    }
}

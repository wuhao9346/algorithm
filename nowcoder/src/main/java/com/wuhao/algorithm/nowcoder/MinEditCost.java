package com.wuhao.algorithm.nowcoder;

public class MinEditCost {
    public static final String NAME = "NC35 编辑距离(二)";

    public int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        char[] chars1 = str1.toCharArray();
        int length1 = chars1.length;
        char[] chars2 = str2.toCharArray();
        int length2 = chars2.length;
        int[] prev = new int[length2 + 1];
        for (int i = 1; i <= length2; i++) {
            prev[i] = i * ic;
        }
        int[] current = new int[length2 + 1];
        for (int i = 1; i <= length1; i++) {
            current[0] = i * dc;
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    current[j] = prev[j - 1];
                } else {
                    current[j] = Math.min(current[j - 1] + ic, prev[j] + dc);
                    current[j] = Math.min(current[j], prev[j - 1] + rc);
                }
            }
            int[] temp = prev;
            prev = current;
            current = temp;
        }
        return prev[length2];
    }

    /**
     * 二维数组实现，清晰的动态规划逻辑
     */
    public int minEditCost2(String str1, String str2, int ic, int dc, int rc) {
        char[] chars1 = str1.toCharArray();
        int length1 = chars1.length;
        char[] chars2 = str2.toCharArray();
        int length2 = chars2.length;
        int[][] c = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            c[i][0] = i * dc;
        }
        for (int i = 1; i <= length2; i++) {
            c[0][i] = i * ic;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                // 转移方程
                if (chars1[i - 1] == chars2[j - 1]) {
                    c[i][j] = c[i - 1][j - 1];
                } else {
                    c[i][j] = Math.min(c[i][j - 1] + ic, c[i - 1][j] + dc);
                    c[i][j] = Math.min(c[i][j], c[i - 1][j - 1] + rc);
                }
            }
        }
        return c[length1][length2];
    }

}

package com.wuhao.algorithm.leetcode;

public class MaximalRectangle {
    public static final String NAME = "LCR 040. 最大矩形";

    public int maximalRectangle(String[] matrix) {
        if (matrix == null || matrix.length < 1) {
            return 0;
        }
        int n = matrix[0].length();
        int rtn = 0;
        int[] height = new int[n];
        for (String s : matrix) {
            for (int j = 0; j < n; j++) {
                height[j] = s.charAt(j) == '1' ? height[j] + 1 : 0;
            }
            int[] stack = new int[n + 1];
            int top = 0;
            stack[0] = -1;
            for (int j = 0; j <= n; j++) {
                while (top != 0 && (j == n || height[stack[top]] >= height[j])) {
                    int area = height[stack[top]] * (j - stack[top - 1] - 1);
                    if (area > rtn) {
                        rtn = area;
                    }
                    top--;
                }
                stack[++top] = j;
            }
        }
        return rtn;
    }
}

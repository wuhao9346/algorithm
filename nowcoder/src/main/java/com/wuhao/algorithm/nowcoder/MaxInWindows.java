package com.wuhao.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindows {
    public static final String NAME = "NC82 滑动窗口的最大值";

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (size == 0 || size > num.length) {
            return result;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] > num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            if (deque.getFirst() + size <= i) {
                deque.removeFirst();
            }

            if (i + 1 >= size) {
                result.add(num[deque.getFirst()]);
            }
        }
        return result;
    }
}

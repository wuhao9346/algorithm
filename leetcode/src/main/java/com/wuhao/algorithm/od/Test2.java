package com.wuhao.algorithm.od;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            Integer[] cPsns = Arrays.stream(in.nextLine().split(","))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = in.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    map[i][j] = row[j].charAt(0) - '0';
                }
            }

            Set<Integer> set = new HashSet<>();
            Deque<Integer> deque = new LinkedList<>();
            for (Integer cPsn : cPsns) {
                deque.add(cPsn);
                set.add(cPsn);
            }
            int count = 0;
            while (!deque.isEmpty()) {
                Integer current = deque.removeFirst();
                for (int i = 0; i < n; i++) {
                    if (map[current][i] == 1 && !set.contains(i)) {
                        set.add(i);
                        deque.addLast(i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

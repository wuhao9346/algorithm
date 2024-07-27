package com.wuhao.algorithm.od;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            StringBuilder builder = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (i + 2 < chars.length && chars[i + 2] == '*'
                        && chars[i] == '1' && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    builder.append((char) (Integer.parseInt(str.substring(i, i + 2)) - 10 + 'j'));
                    i += 2;
                    continue;
                }
                if (i + 2 < chars.length && chars[i + 2] == '*'
                        && chars[i] == '2' && chars[i + 1] >= '0' && chars[i + 1] <= '6') {
                    builder.append((char) (Integer.parseInt(str.substring(i, i + 2)) - 20 + 't'));
                    i += 2;
                    continue;
                }
                if (chars[i] >= '1' && chars[i] <= '9') {
                    builder.append((char) (chars[i] - '1' + 'a'));
                    continue;
                }
                builder.append(chars[i]);
            }
            System.out.println(builder);
        }
    }
}

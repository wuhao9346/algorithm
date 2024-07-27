package com.wuhao.algorithm.od;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int length = Integer.parseInt(in.nextLine());
            Integer[] nums = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            int n = Integer.parseInt(in.nextLine());
            if (n >= length) {
                System.out.println(Arrays.stream(nums).reduce(0, Integer::sum));
                continue;
            }
            int[] caleNums = new int[2 * n];
            for (int i = 0; i < n; i++) {
                caleNums[n - 1 - i] = nums[i];
            }
            for (int i = 0; i < n; i++) {
                caleNums[n + i] = nums[nums.length - 1 - i];
            }
            int maxCount = 0;
            int count = 0;
            int left = 0;
            int right = 0;
            while (right < 2 * n) {
                count += caleNums[right++];
                if (right - left == n) {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count -= caleNums[left++];
                }
            }
            System.out.println(maxCount);
        }
    }
}

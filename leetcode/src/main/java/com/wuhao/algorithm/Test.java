package com.wuhao.algorithm;

import com.wuhao.algorithm.leetcode.structure.ListNode;
import com.wuhao.algorithm.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import static com.wuhao.algorithm.leetcode.structure.ListNode.buildListNode;
import static com.wuhao.algorithm.leetcode.structure.TreeNode.buildTree;
import static com.wuhao.algorithm.leetcode.structure.TreeNode.print;

public class Test {


    private static void merge() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    // 合并两个有序数组，nums2合并到nums1中，nums1的大小是m+n
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (i1 < 0) {
                nums1[i] = nums2[i2--];
                continue;
            }
            if (i2 < 0) {
                nums1[i] = nums1[i1--];
                continue;
            }
            if (nums1[i1] < nums2[i2]) {
                nums1[i] = nums2[i2--];
            } else {
                nums1[i] = nums1[i1--];
            }
        }
    }

    private static void removeElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
                continue;
            }
            if (nums[right] == val) {
                right--;
                continue;
            }
            nums[left++] = nums[right--];
        }
        return left;
    }

    private static void removeDuplicates() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }


    public static int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                if (slow != fast) {
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }
        return slow;
    }

    private static void majorityElement() {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int value = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                value = num;
                count++;
                continue;
            }
            if (value == num) {
                count++;
            } else {
                count--;
            }
        }
        return value;
    }

    public static void rotate() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{-1, -100, 3, 99};
        k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k % nums.length - 1);
        swap(nums, (k % nums.length), nums.length - 1);
    }

    private static void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static void maxProfit() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));

        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));


    }

    public static int maxProfit(int[] prices) {
//        if (prices.length < 2) {
//            return 0;
//        }
//        int max = 0;
//        int profit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            profit = profit + prices[i] - prices[i - 1];
//            if (profit < 0) {
//                profit = 0;
//            }
//            if (profit > max) {
//                max = profit;
//            }
//        }
//        return max;

        if (prices.length < 2) {
            return 0;
        }
        int sum = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                sum += profit;
            }
        }
        return sum;
    }

    public static void canJump() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void jump() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > max) {
                max = i + nums[i];
                count++;
            }
            if (max >= nums.length - 1) {
                return count;
            }
        }
        return count;
    }

    public static void hIndex() {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));

        citations = new int[]{1, 3, 1};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation > citations.length) {
                citation = citations.length;
            }
            count[citation]++;
        }
        int sum = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void productExceptSelf() {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i = 1; i < answer.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] *= r;
            r *= nums[i];
        }
        return answer;
    }

    public static void isValid() {
        String s = "()";
        System.out.println(isValid(s));

        s = "()[]{}";
        System.out.println(isValid(s));

        s = "(]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (index == 0 || ch == '(' || ch == '[' || ch == '{') {
                stack[index++] = ch;
                continue;
            }
            char topChar = stack[index - 1];
            if (ch == ')' && topChar == '(') {
                index--;
                continue;
            }
            if (ch == ']' && topChar == '[') {
                index--;
                continue;
            }
            if (ch == '}' && topChar == '{') {
                index--;
                continue;
            }
            stack[index++] = ch;
        }
        return index == 0;
    }


    public static void simplifyPath() {
        String path = "/home/";
        System.out.println(simplifyPath(path));

        path = "/../";
        System.out.println(simplifyPath(path));

        path = "/home//foo/";
        System.out.println(simplifyPath(path));

        path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] segments = path.split("/");
        String[] stack = new String[segments.length];
        int index = 0;
        for (String segment : segments) {
            if (".".equals(segment) || "".equals(segment)) {
                continue;
            }
            if ("..".equals(segment)) {
                if (index > 0) {
                    index--;
                }
                continue;
            }
            stack[index++] = segment;
        }
        if (index < 1) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append("/").append(stack[i]);
        }
        return result.toString();
    }

    public static void evalRPN() {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int[] valueStack = new int[(tokens.length + 1) / 2];
        int index = 0;

        for (String token : tokens) {
            if ("+".equals(token)) {
                int value2 = valueStack[--index];
                int value1 = valueStack[--index];
                valueStack[index++] = value1 + value2;
                continue;
            }
            if ("-".equals(token)) {
                int value2 = valueStack[--index];
                int value1 = valueStack[--index];
                valueStack[index++] = value1 - value2;
                continue;
            }
            if ("*".equals(token)) {
                int value2 = valueStack[--index];
                int value1 = valueStack[--index];
                valueStack[index++] = value1 * value2;
                continue;
            }
            if ("/".equals(token)) {
                int value2 = valueStack[--index];
                int value1 = valueStack[--index];
                valueStack[index++] = value1 / value2;
                continue;
            }
            valueStack[index++] = Integer.parseInt(token);
        }
        return valueStack[index - 1];
    }

    public static void calculate() {
        String s = "1 + 1";
//        System.out.println(calculate(s));
//        s = " 2-1 + 2 ";
//        System.out.println(calculate(s));
//        s = "(1+(4+5+2)-3)+(6+8)";
//        System.out.println(calculate(s));
//        s = "0";
//        System.out.println(calculate(s));
//        s = "1-(     -2)";
//        System.out.println(calculate(s));
//        s = "-2+ 1";
//        System.out.println(calculate(s));
//        s = "- (3 + (4 + 5))";
//        System.out.println(calculate(s));
        s = "2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> valueStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            valueStack.push(0);
        }

        int value = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (value == -1) {
                    value = ch - '0';
                } else {
                    value = value * 10 + ch - '0';
                }
                continue;
            }
            if (value != -1) {
                valueStack.push(value);
                value = -1;
            }

            if (ch == '(') {
                operatorStack.push(ch);
                if (i + 1 < s.length()) {
                    char nextChar = s.charAt(i + 1);
                    if (nextChar == '-' || nextChar == '+') {
                        valueStack.push(0);
                    }
                }
            } else if (ch == ')') {
                calculate(valueStack, operatorStack, true);
            } else {
                calculate(valueStack, operatorStack, false);
                operatorStack.push(ch);
            }
        }
        if (value != -1) {
            valueStack.push(value);
        }
        calculate(valueStack, operatorStack, false);
        return valueStack.peek();
    }

    private static void calculate(Stack<Integer> valueStack, Stack<Character> operatorStack, boolean removeLevel) {

        while (!operatorStack.empty() && valueStack.size() >= 2) {

            char oper = operatorStack.peek();
            if (oper == '(') {
                if (removeLevel) {
                    removeLevel = false;
                    operatorStack.pop();
                    continue;
                } else {
                    break;
                }
            }
            oper = operatorStack.pop();
            Integer value2 = valueStack.pop();
            Integer value1 = valueStack.pop();
            if ('+' == oper) {
                valueStack.push(value1 + value2);
            } else if ('-' == oper) {
                valueStack.push(value1 - value2);
            } else if ('*' == oper) {
                valueStack.push(value1 * value2);
            } else if ('/' == oper) {
                valueStack.push(value1 / value2);
            }
        }
    }


    public static void addTwoNumbers() {
        ListNode l1 = buildListNode(new int[]{2, 4, 3});
        ListNode l2 = buildListNode(new int[]{5, 6, 4});
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        l1 = buildListNode(new int[]{0});
        l2 = buildListNode(new int[]{0});
        result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

        l1 = buildListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = buildListNode(new int[]{9, 9, 9, 9});
        result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode prevResultNode = null;
        while (l1 != null || l2 != null) {
            ListNode l3 = null;
            if (prevResultNode != null) {
                l3 = prevResultNode.next;
            }
            if (l3 == null) {
                l3 = new ListNode(0);
                if (prevResultNode != null) {
                    prevResultNode.next = l3;
                }
            }
            if (l1 != null) {
                l3.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l3.val += l2.val;
                l2 = l2.next;
            }
            if (result == null) {
                result = l3;
            }
            prevResultNode = l3;
            if (l3.val / 10 > 0) {
                l3.val = l3.val % 10;
                l3.next = new ListNode(1);
            }
        }
        return result;
    }

    public static void mergeTwoLists() {
        ListNode list1 = buildListNode(new int[]{1, 2, 4});
        ListNode list2 = buildListNode(new int[]{1, 3, 4});
        ListNode resultNode = mergeTwoLists(list1, list2);
        while (resultNode != null) {
            System.out.printf("%s\t", resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println();


        list1 = buildListNode(new int[]{});
        list2 = buildListNode(new int[]{});
        resultNode = mergeTwoLists(list1, list2);
        while (resultNode != null) {
            System.out.printf("%s\t", resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println();

        list1 = buildListNode(new int[]{});
        list2 = buildListNode(new int[]{0});
        resultNode = mergeTwoLists(list1, list2);
        while (resultNode != null) {
            System.out.printf("%s\t", resultNode.val);
            resultNode = resultNode.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = list2.val < list1.val ? list2 : list1;
        ListNode target = result;
        ListNode source = list2.val < list1.val ? list1 : list2;
        while (target != null && source != null) {
            int nextValue = Integer.MAX_VALUE;
            if (target.next != null) {
                nextValue = target.next.val;
            }
            if (source.val >= target.val && source.val < nextValue) {
                ListNode node = source;
                source = source.next;
                node.next = target.next;
                target.next = node;
                target = node;
                continue;
            }
            target = target.next;
        }
        return result;
    }

    public static void trap() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

        height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int sum = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                sum += maxLeft - height[left];
                left++;
                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                }
            } else {
                sum += maxRight - height[right];
                right--;
                if (height[right] > maxRight) {
                    maxRight = height[right];
                }
            }
        }
        return sum;
    }

    public static void romanToInt() {
        String s = "III";
        System.out.println(romanToInt(s));

        s = "IV";
        System.out.println(romanToInt(s));

        s = "IX";
        System.out.println(romanToInt(s));

        s = "LVIII";
        System.out.println(romanToInt(s));

        s = "MCMXCIV";
        System.out.println(romanToInt(s));
        s = "XLIX";
        System.out.println(romanToInt(s));

        s = "CMXCIX ";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charValue = romanCharToInt(ch);
            if (charValue <= value) {
                sum += value;
                value = charValue;
            } else {
                value = charValue - value;
            }
        }
        return sum + value;
    }

    private static int romanCharToInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void intToRoman() {
        int num = 3749;
        System.out.println(intToRoman(num));
        num = 58;
        System.out.println(intToRoman(num));
        num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanBuilder = new StringBuilder(10);
        while (num > 0) {
            for (int i = 0; i < values.length; i++) {
                if (num >= values[i]) {
                    romanBuilder.append(symbols[i]);
                    num -= values[i];
                    break;
                }
            }
        }
        return romanBuilder.toString();
    }

    public static void lengthOfLastWord() {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));

        s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));

        s = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ' && length > 0) {
                return length;
            }
            if (ch != ' ') {
                length++;
            }
        }
        return length;
    }

    public static void longestCommonPrefix() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        char[] prefix = strs[0].toCharArray();
        int length = prefix.length;
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() < length) {
                length = str.length();
            }
            for (int j = 0; j < length; j++) {
                if (str.charAt(j) != prefix[j]) {
                    length = j;
                }
            }
            if (length == 0) {
                break;
            }
        }
        return new String(prefix, 0, length);
    }

    public static void reverseWords() {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        s = "  hello world  ";
        System.out.println(reverseWords(s));

        s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = words.length - 1; i >= 0; i--) {
            if ("".equals(words[i])) {
                continue;
            }
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(words[i]);
        }

        return builder.toString();
    }


    public static void strStr() {

        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void fullJustify() {
        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(System.out::println);
        fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16).forEach(System.out::println);
        fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20).forEach(System.out::println);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rowList = new ArrayList<>();
        List<String> rowWordList = new ArrayList<>();
        StringBuilder rowBuilder = new StringBuilder(maxWidth);
        int rowLength = 0;
        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            rowWordList.add(word);
            rowLength += word.length() + 1;

            if (j != words.length - 1 && rowLength + words[j + 1].length() <= maxWidth) {
                continue;
            }

            if (j == words.length - 1 || rowWordList.size() == 1) {
                rowBuilder.setLength(0);
                rowBuilder.append(String.join(" ", rowWordList));
                while (rowBuilder.length() < maxWidth) {
                    rowBuilder.append(' ');
                }
                rowList.add(rowBuilder.toString());
            } else {
                int charLength = rowLength - rowWordList.size();
                int spaceLength = maxWidth - charLength;
                int spaceCount = rowWordList.size() - 1;
                rowBuilder.setLength(0);
                rowBuilder.append(rowWordList.get(0));
                for (int i = 1; i < rowWordList.size(); i++) {
                    int spaceCharCount = spaceLength / spaceCount + (spaceLength % spaceCount > 0 ? 1 : 0);
                    spaceLength -= spaceCharCount;
                    spaceCount--;
                    while (spaceCharCount > 0) {
                        rowBuilder.append(' ');
                        spaceCharCount--;
                    }
                    rowBuilder.append(rowWordList.get(i));
                }
                rowList.add(rowBuilder.toString());
            }
            rowWordList.clear();
            rowLength = 0;
        }
        return rowList;
    }

    public static void isPalindrome() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !isLetter(s.charAt(left)) && !isNum(s.charAt(left))) {
                left++;
            }
            while (left <= right && !isLetter(s.charAt(right)) && !isNum(s.charAt(right))) {
                right--;
            }
            if (left <= right) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if (toLowerCase(leftChar) != toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private static char toLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch - 'A' + 'a');
        }
        return ch;
    }

    private static boolean isLetter(char ch) {
        return ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z';
    }

    private static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static void isSubsequence() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            while (left < t.length() && s.charAt(i) != t.charAt(left)) {
                left++;
            }
            if (left == t.length()) {
                return false;
            }
            left++;
        }
        return true;
    }

    public static void twoSum() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void maxArea() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = height[left];
            if (height[right] < minHeight) {
                minHeight = height[right];
            }
            int area = minHeight * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }
        return maxArea;
    }

    public static void threeSum() {
        System.out.println("-----------------------------------------");
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(comp -> {
            comp.forEach(value -> System.out.printf("%s\t", value));
            System.out.println();
        });
        System.out.println("-----------------------------------------");
        threeSum(new int[]{0, 1, 1}).forEach(comp -> {
            comp.forEach(value -> System.out.printf("%s\t", value));
            System.out.println();
        });
        System.out.println("-----------------------------------------");
        threeSum(new int[]{0, 0, 0}).forEach(comp -> {
            comp.forEach(value -> System.out.printf("%s\t", value));
            System.out.println();
        });
        System.out.println("-----------------------------------------");
        threeSum(new int[]{0, 0, 0, 0}).forEach(comp -> {
            comp.forEach(value -> System.out.printf("%s\t", value));
            System.out.println();
        });
        System.out.println("-----------------------------------------");
        threeSum(new int[]{3, -2, 1, 0}).forEach(comp -> {
            comp.forEach(value -> System.out.printf("%s\t", value));
            System.out.println();
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void minSubArrayLen() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

        System.out.println(minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = nums.length + 1;
        while (right < nums.length) {
            target -= nums[right];
            while (target <= 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                }
                target += nums[left++];
            }
            right++;
        }
        return minLength > nums.length ? 0 : minLength;
    }

    public static void lengthOfLongestSubstring() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[127];
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r < s.length()) {
            while (flag[s.charAt(r)]) {
                flag[s.charAt(l++)] = false;
            }
            flag[s.charAt(r)] = true;
            if (r - l + 1 > maxLength) {
                maxLength = r - l + 1;
            }
            r++;
        }
        return maxLength;
    }

    public static void findSubstring() {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(findSubstring("aaaaaaaaaaaaaa", new String[]{"aa", "aa"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordCountMap = new HashMap<>(words.length);
        for (String word : words) {
            int count = wordCountMap.getOrDefault(word, 0);
            wordCountMap.put(word, count + 1);
        }
        int wordLength = words[0].length();
        int subStringLength = words.length * wordLength;
        int start = 0;
        while (start < wordLength) {
            int l = start;
            int r = start;
            Map<String, Integer> tempWordCountMap = new HashMap<>(wordCountMap);
            while (r + wordLength <= s.length()) {
                String word = s.substring(r, r + wordLength);
                while (l < r && tempWordCountMap.getOrDefault(word, 0) == 0) {
                    String removeWord = s.substring(l, l + wordLength);
                    tempWordCountMap.put(removeWord, tempWordCountMap.get(removeWord) + 1);
                    l += wordLength;
                }
                if (!tempWordCountMap.containsKey(word)) {
                    l += wordLength;
                    r += wordLength;
                    continue;
                }
                tempWordCountMap.put(word, tempWordCountMap.get(word) - 1);
                if (r + wordLength - l == subStringLength) {
                    result.add(l);
                }
                r += wordLength;
            }
            start++;
        }
        return result;
    }

    public static void minWindow() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        int[] charCount = new int[128];
        boolean[] charFlag = new boolean[128];
        for (int i = 0; i < t.length(); i++) {
            charFlag[t.charAt(i)] = true;
            charCount[t.charAt(i)]++;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        String result = null;
        while (r < s.length() && count < t.length()) {
            char rch = s.charAt(r);
            if (charFlag[rch]) {
                charCount[rch]--;
                if (charCount[rch] >= 0) {
                    count++;
                }
            }
            while (l <= r && count == t.length()) {
                char lch = s.charAt(l);
                if (charFlag[lch]) {
                    charCount[lch]++;
                    if (charCount[lch] > 0) {
                        count--;
                        if (result == null || r - l + 1 < result.length()) {
                            result = s.substring(l, r + 1);
                        }
                    }
                }
                l++;
            }
            r++;
        }
        return result == null ? "" : result;
    }

    public static void isValidSudoku() {
        System.out.println(isValidSudoku(new char[][]{new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},}));
        System.out.println(isValidSudoku(new char[][]{new char[]{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'},}));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[] rowFlag = new boolean[9];
        boolean[][] columnFlag = new boolean[9][9];
        boolean[][] blockFlag = new boolean[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '1';
                if (rowFlag[num] || columnFlag[j][num] || blockFlag[j / 3][num]) {
                    return false;
                }
                rowFlag[num] = true;
                columnFlag[j][num] = true;
                blockFlag[j / 3][num] = true;
            }
            Arrays.fill(rowFlag, false);
            if (i % 3 == 2) {
                for (boolean[] black : blockFlag) {
                    Arrays.fill(black, false);
                }
            }
        }
        return true;
    }

    public static void spiralOrder() {
        System.out.println(spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, new int[]{9, 10, 11, 12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int count = rowCount * columnCount;
        List<Integer> result = new ArrayList<>(count);
        int rowIndex = 0;
        int columnIndex = 0;
        result.add(matrix[rowIndex][columnIndex]);
        matrix[rowIndex][columnIndex] = Integer.MAX_VALUE;
        while (result.size() < count) {
            while (columnIndex + 1 < columnCount && matrix[rowIndex][columnIndex + 1] != Integer.MAX_VALUE) {
                columnIndex++;
                result.add(matrix[rowIndex][columnIndex]);
                matrix[rowIndex][columnIndex] = Integer.MAX_VALUE;
            }
            while (rowIndex + 1 < rowCount && matrix[rowIndex + 1][columnIndex] != Integer.MAX_VALUE) {
                rowIndex++;
                result.add(matrix[rowIndex][columnIndex]);
                matrix[rowIndex][columnIndex] = Integer.MAX_VALUE;
            }
            while (columnIndex - 1 >= 0 && matrix[rowIndex][columnIndex - 1] != Integer.MAX_VALUE) {
                columnIndex--;
                result.add(matrix[rowIndex][columnIndex]);
                matrix[rowIndex][columnIndex] = Integer.MAX_VALUE;
            }
            while (rowIndex - 1 >= 0 && matrix[rowIndex - 1][columnIndex] != Integer.MAX_VALUE) {
                rowIndex--;
                result.add(matrix[rowIndex][columnIndex]);
                matrix[rowIndex][columnIndex] = Integer.MAX_VALUE;
            }
        }
        return result;
    }

    public static void rotate2() {
        int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        rotate2(matrix);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }

        matrix = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
        rotate2(matrix);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void setZeroes() {
        int[][] matrix = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }

        matrix = new int[][]{new int[]{0, 1, 2, 0}, new int[]{3, 4, 5, 2}, new int[]{1, 3, 1, 5}};
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        boolean[] rowFlag = new boolean[matrix.length];
        boolean[] columnFlag = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    columnFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowFlag[i] || columnFlag[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void gameOfLife() {
        int[][] board = new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}};
        gameOfLife(board);
        for (int[] row : board) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }

        board = new int[][]{new int[]{1, 1}, new int[]{1, 0},};
        gameOfLife(board);
        for (int[] row : board) {
            for (int value : row) {
                System.out.printf("%s\t", value);
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        // 0 死
        // 1 活
        // 2 死->活
        // 3 活->死

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = 0;
                for (int k = i - 1; k < i + 2; k++) {
                    if (k < 0 || k >= board.length) {
                        continue;
                    }
                    for (int l = j - 1; l < j + 2; l++) {
                        if (l < 0 || l >= board[0].length) {
                            continue;
                        }
                        if (k == i && l == j) {
                            continue;
                        }
                        if (board[k][l] == 1 || board[k][l] == 3) {
                            count++;
                        }
                    }
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                    continue;
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                    continue;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void canConstruct() {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--charCount[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void isIsomorphic() {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] mapper = new int[128];
        boolean[] flag = new boolean[128];
        int length = s.length();
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        for (int i = 0; i < length; i++) {
            char ch = schars[i];
            char tch = tchars[i];
            if (mapper[ch] == 0 && flag[tch]) {
                return false;
            }
            if (mapper[ch] == 0) {
                mapper[ch] = tch;
                flag[tch] = true;
                continue;
            }
            if (mapper[ch] != tch) {
                return false;
            }
        }
        return true;
    }

    public static void wordPattern() {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        char[] patternChars = pattern.toCharArray();
        String[] mapper = new String[26];
        Set<String> mapperWordSet = new HashSet<>(words.length);
        for (int i = 0; i < words.length; i++) {
            if (mapper[patternChars[i] - 'a'] == null && mapperWordSet.contains(words[i])) {
                return false;
            }
            if (mapper[patternChars[i] - 'a'] == null) {
                mapper[patternChars[i] - 'a'] = words[i];
                mapperWordSet.add(words[i]);
                continue;
            }
            if (!mapper[patternChars[i] - 'a'].equals(words[i])) {
                return false;
            }
        }
        return true;
    }

    public static void isAnagram() {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            count[ch - 'a']++;
        }
        chars = t.toCharArray();
        for (char ch : chars) {
            count[ch - 'a']--;
            if (count[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void groupAnagrams() {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(group -> System.out.println(String.join(",", group)));
        groupAnagrams(new String[]{""}).forEach(group -> System.out.println(String.join(",", group)));
        groupAnagrams(new String[]{"a"}).forEach(group -> System.out.println(String.join(",", group)));
        groupAnagrams(new String[]{"ac", "c"}).forEach(group -> System.out.println(String.join(",", group)));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = buildKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private static String buildKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void twoSum2() {
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndexMap.containsKey(target - nums[i])) {
                return new int[]{numIndexMap.get(target - nums[i]), i};
            }
            numIndexMap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void isHappy() {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        int next = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.add(n) && (next = calcNext(n)) != 1) {
            n = next;
        }
        return next == 1;
    }

    private static int calcNext(int n) {
        int next = 0;
        while (n > 0) {
            next += Math.pow(n % 10, 2);
            n /= 10;
        }
        return next;
    }

    public static void containsNearbyDuplicate() {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while (r - l <= k && r < nums.length) {
            if (!hashSet.add(nums[r++])) {
                return true;
            }
            if (r - l > k) {
                hashSet.remove(nums[l++]);
            }
        }
        return false;
    }

    public static void longestConsecutive() {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                length++;
            } else if (nums[i] - nums[i - 1] > 1) {
                length = 1;
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static void summaryRanges() {
//        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
//        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>(nums.length);
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i + 1] > nums[i] + 1) {
                if (i == l) {
                    result.add(String.valueOf(nums[l]));
                } else {
                    result.add(String.format("%s->%s", nums[l], nums[i]));
                }
                l = i + 1;
            }
        }
        return result;
    }

    public static void merge2() {
        System.out.println(Arrays.stream(merge2(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}})).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(merge2(new int[][]{new int[]{1, 4}, new int[]{4, 5}})).map(Arrays::toString).collect(Collectors.joining(",")));
    }

    public static int[][] merge2(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
                continue;
            }
            int[] prev = result.get(result.size() - 1);
            if (interval[0] > prev[1]) {
                result.add(interval);
            } else {
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void insert() {
        System.out.println(Arrays.stream(insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5})).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(insert(new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}}, new int[]{4, 8})).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(insert(new int[][]{new int[]{1, 5}}, new int[]{6, 8})).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(insert(new int[][]{}, new int[]{1, 5})).map(Arrays::toString).collect(Collectors.joining(",")));
        System.out.println(Arrays.stream(insert(new int[][]{new int[]{1, 5}}, new int[]{0, 0})).map(Arrays::toString).collect(Collectors.joining(",")));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        boolean inserted = false;
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0] && !inserted) {
                result.add(newInterval);
                result.add(interval);
                inserted = true;
                continue;
            }
            if (!(newInterval[0] > interval[1] || newInterval[1] < interval[0])) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                if (!inserted) {
                    inserted = true;
                    result.add(newInterval);
                }
                continue;
            }
            result.add(interval);
        }
        if (!inserted) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void findMinArrowShots() {
        System.out.println(findMinArrowShots(new int[][]{new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}}));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length < 1) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int right = points[0][1], count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                count++;
                right = points[i][1];
            }
        }
        return count;
    }

    public static void maxDepth() {
        TreeNode root = buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(maxDepth(root));
        root = buildTree(new Integer[]{1, null, 2});
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void isSameTree() {
        System.out.println(isSameTree(buildTree(new Integer[]{1, 2, 3}), buildTree(new Integer[]{1, 2, 3})));
        System.out.println(isSameTree(buildTree(new Integer[]{1, 2}), buildTree(new Integer[]{1, null, 2})));
        System.out.println(isSameTree(buildTree(new Integer[]{1, 2, 1}), buildTree(new Integer[]{1, 1, 2})));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void invertTree() {
        print(invertTree(buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        print(invertTree(buildTree(new Integer[]{2, 1, 3})));
        print(invertTree(buildTree(new Integer[]{})));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }

    public static void isSymmetric() {
        System.out.println(isSymmetric(buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(isSymmetric(buildTree(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null & root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static void buildTreeByPI() {
        print(buildTreeByPI(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        print(buildTreeByPI(new int[]{-1}, new int[]{-1}));
        print(buildTreeByPI(new int[]{1, 2}, new int[]{2, 1}));
    }

    public static TreeNode buildTreeByPI(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeByIP(preorder, 0, preorder.length - 1, 0, inorder.length - 1, indexMap);
    }

    public static void buildTreeByIP() {
        print(buildTreeByIP(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
        print(buildTreeByIP(new int[]{-1}, new int[]{-1}));
        print(buildTreeByIP(new int[]{1, 2}, new int[]{2, 1}));
    }

    public static TreeNode buildTreeByIP(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeByIP(postorder, 0, postorder.length - 1, 0, inorder.length - 1, indexMap);
    }

    public static TreeNode buildTreeByIP(int[] postorder, int postL, int postR, int inL, int inR, HashMap<Integer, Integer> indexMap) {
        if (postL > postR) {
            return null;
        }
        if (postL == postR) {
            return new TreeNode(postorder[postL]);
        }
        int value = postorder[postR];
        int index = indexMap.get(value);
        int leftLength = index - inL;
        TreeNode leftNode = buildTreeByIP(postorder, postL, postL + leftLength - 1, inL, index - 1, indexMap);
        int rightLength = inR - index;
        TreeNode rightNode = buildTreeByIP(postorder, postR - rightLength, postR - 1, index + 1, inR, indexMap);
        return new TreeNode(value, leftNode, rightNode);
    }

    public static void connect() {

        print(connect(buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7})));
        print(connect(buildTree(new Integer[]{})));
    }

    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode preNode = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (preNode != null) {
                    preNode.next = node;
                }
                preNode = node;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static void flatten() {
        TreeNode root = buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten(root);
        print(root);
        root = buildTree(new Integer[]{});
        flatten(root);
        print(root);
        root = buildTree(new Integer[]{0});
        flatten(root);
        print(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode node = current.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    public static TreeNode flattenNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode lastNode = null;
        if (node.right != null) {
            lastNode = flattenNode(node.right);
        }
        if (node.left != null) {
            TreeNode leftLastNode = flattenNode(node.left);
            leftLastNode.right = node.right;
            node.right = node.left;
            node.left = null;
            if (lastNode == null) {
                return leftLastNode;
            }
        }
        return lastNode;
    }

    public static void hasPathSum() {
        System.out.println(hasPathSum(buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        System.out.println(hasPathSum(buildTree(new Integer[]{1, 2, 3}), 5));
        System.out.println(hasPathSum(buildTree(new Integer[]{}), 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void sumNumbers() {
        System.out.println(sumNumbers(buildTree(new Integer[]{1, 2, 3})));
        System.out.println(sumNumbers(buildTree(new Integer[]{4, 9, 0, 5, 1})));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    public static int sumNumbers(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
    }

    public static void main(String[] args) {

    }

    class MinStack {
        private Node top;
        private Node min;


        public MinStack() {

        }

        public void push(int val) {
            Node valueNode = new Node();
            valueNode.value = val;
            Node minValueNode = new Node();
            minValueNode.value = val;
            if (top == null) {
                top = valueNode;
                min = minValueNode;
                return;
            }

            valueNode.prev = top;
            top = valueNode;
            if (min.value < minValueNode.value) {
                minValueNode.value = min.value;
            }
            minValueNode.prev = min;
            min = minValueNode;

        }

        public void pop() {
            Node node = top;
            top = top.prev;
            node.prev = null;
            node = min;
            min = min.prev;
            node.prev = null;
        }

        public int top() {
            return top.value;
        }

        public int getMin() {
            return min.value;
        }

        private final class Node {
            private int value;
            private Node prev;
        }
    }


    private static final class RandomizedSet {
        private final ArrayList<Integer> valueList;
        private final Map<Integer, Integer> valueIndexMap;
        private final Random random;

        public RandomizedSet() {
            valueList = new ArrayList<>();
            valueIndexMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (valueIndexMap.containsKey(val)) {
                return false;
            }
            valueList.add(val);
            valueIndexMap.put(val, valueList.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!valueIndexMap.containsKey(val)) {
                return false;
            }
            int index = valueIndexMap.remove(val);
            if (index == valueList.size() - 1) {
                valueList.remove(index);
            } else {
                int lastValue = valueList.get(valueList.size() - 1);
                valueList.set(index, lastValue);
                valueList.remove(valueList.size() - 1);
                valueIndexMap.put(lastValue, index);
            }
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(valueList.size());
            return valueList.get(index);
        }
    }
}

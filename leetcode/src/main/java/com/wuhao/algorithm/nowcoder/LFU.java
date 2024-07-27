package com.wuhao.algorithm.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LFU {
    public static final String NAME = "NC94 设计LFU缓存结构";

    public int[] LFU(int[][] operators, int k) {
        List<Integer> result = new ArrayList<>();
        LFUCache cache = new LFUCache(k);
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                cache.set(operator[1], operator[2]);
            } else if (operator[0] == 2) {
                result.add(cache.get(operator[1]));
            }
        }
        int[] results = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            results[i] = result.get(i);
        }
        return results;
    }

    public static class LFUCache {
        private final int capacity;
        private final HashMap<Integer, Entry> entryMap = new HashMap<>();
        private int size = 0;
        private final Entry head;
        private final Entry tail;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Entry();
            this.tail = new Entry();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            Entry entry = entryMap.get(key);
            if (entry == null) {
                return -1;
            }
            entry.times++;
            move(entry);
            return entry.value;
        }

        public void set(int key, int value) {

            Entry entry = entryMap.get(key);
            if (entry == null) {
                entry = new Entry(key);
                entryMap.put(key, entry);
                size++;
            }
            entry.value = value;
            entry.times++;

            if (size > capacity) {
                entryMap.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next.prev = null;
                tail.prev.next.next = null;
                tail.prev.next = tail;
            }

            move(entry);
        }

        private void move(Entry entry) {
            Entry prev = entry.prev;
            if (prev == null) {
                prev = tail.prev;
            }

            while (!head.equals(prev) && prev.times <= entry.times) {
                prev = prev.prev;
            }

            if (prev.equals(entry.prev)) {
                return;
            }
            if (entry.prev != null) {
                entry.prev.next = entry.next;
                entry.next.prev = entry.prev;
            }
            entry.next = prev.next;
            prev.next.prev = entry;
            entry.prev = prev;
            prev.next = entry;
        }

        private static final class Entry {
            private int key;
            private int value;
            private Entry prev;
            private Entry next;
            private int times;

            public Entry() {
            }

            private Entry(int key) {
                this.key = key;
            }
        }
    }
}

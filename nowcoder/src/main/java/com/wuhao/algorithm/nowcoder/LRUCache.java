package com.wuhao.algorithm.nowcoder;


import com.wuhao.algorithm.common.structure.Entry;

import java.util.HashMap;

public class LRUCache {

    public static final String NAME = "NC93 设计LRU缓存结构";
    private final int capacity;
    private final HashMap<Integer, Entry> entryMap = new HashMap<>();
    private int size = 0;
    private final Entry head;
    private final Entry tail;

    public LRUCache(int capacity) {
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
        moveHead(entry);
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
        moveHead(entry);
        if (size > capacity) {
            entryMap.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next.prev = null;
            tail.prev.next.next = null;
            tail.prev.next = tail;
            size--;
        }
    }

    private void moveHead(Entry entry) {
        if (entry.equals(head.next)) {
            return;
        }
        if (entry.prev != null) {
            entry.prev.next = entry.next;
            entry.next.prev = entry.prev;
        }
        entry.next = head.next;
        head.next.prev = entry;
        entry.prev = head;
        head.next = entry;
    }
}
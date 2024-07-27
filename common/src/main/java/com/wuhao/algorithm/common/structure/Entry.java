package com.wuhao.algorithm.common.structure;

import java.util.ArrayList;
import java.util.List;

public final class Entry {
    public int key;
    public int value;
    public Entry prev;
    public Entry next;
    public int times;

    public Entry() {
    }

    public Entry(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        List<String> valueList = new ArrayList<>();
        Entry entry = this;
        while (entry != null) {
            valueList.add("[" + entry.key + "," + entry.value + "]");
            entry = entry.next;
        }
        return "[" + String.join(",", valueList) + "]";
    }
}

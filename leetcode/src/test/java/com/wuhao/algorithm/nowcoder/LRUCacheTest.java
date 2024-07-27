package com.wuhao.algorithm.nowcoder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(LRUCache.NAME)
class LRUCacheTest {

    @Test
    void test() {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        Assertions.assertEquals(1, cache.get(1));
        cache.set(3, 3);
        Assertions.assertEquals(-1, cache.get(2));
        cache.set(4, 4);
        Assertions.assertEquals(-1, cache.get(1));
        Assertions.assertEquals(3, cache.get(3));
        Assertions.assertEquals(4, cache.get(4));
    }
}
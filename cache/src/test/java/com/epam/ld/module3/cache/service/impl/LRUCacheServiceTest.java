package com.epam.ld.module3.cache.service.impl;

import com.epam.ld.module3.cache.service.CacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LRUCacheServiceTest {
    private CacheService lruCacheService;
    private static final int MAX_CACHE_SIZE = 100;

    @BeforeEach
    public void setUp() {
        lruCacheService = new LRUCacheService(MAX_CACHE_SIZE);
        for (int i = 1; i <= 1000; i++) {
            lruCacheService.put(i, i);
            if (i == 3) {
                lruCacheService.get(1);
                lruCacheService.get(2);
                lruCacheService.get(3);
            }
        }
    }

    @Test
    public void shouldAverageTimeToWriteGreaterThanZero() {
        assertTrue(lruCacheService.getCacheStatistics().getAverageWrite() == 0);
    }

    @Test
    public void shouldBeMaxCacheSize100_whenAdded1000() {
        assertTrue(lruCacheService.getCacheSize() == 100);
    }

    @Test
    public void testFailedIfMaxCacheSizeNotEquals100() {
        assertFalse(lruCacheService.getCacheSize() != 100);
    }

    @Test
    public void shouldEvict900EntryFromCache() {
        assertEquals(900, lruCacheService.getCacheStatistics().getNumberEviction());
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    public void testValuesShouldNotBePresent(Integer number) {
        assertNull(lruCacheService.get(number));
    }

}

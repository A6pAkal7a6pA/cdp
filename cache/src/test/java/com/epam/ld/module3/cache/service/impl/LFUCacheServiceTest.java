package com.epam.ld.module3.cache.service.impl;


import com.epam.ld.module3.cache.service.CacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LFUCacheServiceTest {
    private static final int MAX_CACHE_SIZE = 100;
    private CacheService lfuCacheService;

    @BeforeEach
    public void setUp() {
        lfuCacheService = new LFUCacheService(MAX_CACHE_SIZE);
        for (int i = 1; i <= 1000; i++) {
            lfuCacheService.put(i, i);
            if (i == 3) {
                lfuCacheService.get(1);
                lfuCacheService.get(2);
                lfuCacheService.get(3);
            }
        }
    }

    @Test
    public void shouldAverageTimeToWriteGreaterThanZero() {
        assertTrue(lfuCacheService.getCacheStatistics().getAverageWrite() > 0);
    }

    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3})
    public void testValuesShouldBePresent(Integer number) {
        assertNotNull(lfuCacheService.get(number));
    }

    @Test
    public void shouldBeMaxCacheSize100_whenAdded1000() {
        assertTrue(lfuCacheService.getCacheSize() == 100);
    }

    @Test
    public void testFailedIfMaxCacheSizeNotEquals100() {
        assertFalse(lfuCacheService.getCacheSize() != 100);
    }

    @Test
    public void shouldEvict900EntryFromCache() {
        assertEquals(900, lfuCacheService.getCacheStatistics().getNumberEviction());
    }


}

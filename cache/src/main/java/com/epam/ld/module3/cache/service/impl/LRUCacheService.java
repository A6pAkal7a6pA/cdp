package com.epam.ld.module3.cache.service.impl;

import com.epam.ld.module3.cache.entity.CacheStatistic;
import com.epam.ld.module3.cache.listener.impl.LRURemovalListener;
import com.epam.ld.module3.cache.service.CacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

import java.util.concurrent.TimeUnit;

import static com.epam.ld.module3.cache.constant.CacheConstant.DEFAULT_MAX_SIZE;

public class LRUCacheService implements CacheService {
    private final Cache<Integer, Integer> cache;

    /**
     * constructor with default max size
     */
    public LRUCacheService() {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(10)
                .removalListener(new LRURemovalListener())
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(DEFAULT_MAX_SIZE)
                .recordStats()
                .build();
    }

    /**
     * @param maxSize the max size of cache
     */
    public LRUCacheService(int maxSize) {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(10)
                .removalListener(new LRURemovalListener())
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .maximumSize(maxSize)
                .recordStats()
                .build();
    }

    @Override
    public void put(Integer key, Integer value) {
        cache.put(key, value);
    }

    @Override
    public Integer get(Integer key) {
        return cache.getIfPresent(key);
    }

    @Override
    public CacheStatistic getCacheStatistics() {
        CacheStats stats = cache.stats();
        return new CacheStatistic(stats.evictionCount(), stats.averageLoadPenalty());
    }

    @Override
    public long getCacheSize() {
        return cache.size();
    }
}

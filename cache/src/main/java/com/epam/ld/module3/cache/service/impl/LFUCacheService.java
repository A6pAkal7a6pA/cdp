package com.epam.ld.module3.cache.service.impl;


import com.epam.ld.module3.cache.entity.CacheStatistic;
import com.epam.ld.module3.cache.listener.RemovalListener;
import com.epam.ld.module3.cache.listener.impl.LFURemovalListener;
import com.epam.ld.module3.cache.service.CacheService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.epam.ld.module3.cache.constant.CacheConstant.DEFAULT_MAX_SIZE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class LFUCacheService implements CacheService {
    private final RemovalListener lfuRemovalListener;
    private final Map<Integer, Integer[]> cache = new ConcurrentHashMap<>();
    private final CacheStatistic cacheStatistic = new CacheStatistic(0, 0);
    private float totalLoadTime = 0;
    private long totalCount = 0;
    private int maxSize = DEFAULT_MAX_SIZE;

    public LFUCacheService() {
        lfuRemovalListener = new LFURemovalListener();
    }

    public LFUCacheService(int maxSize) {
        this.maxSize = maxSize;
        lfuRemovalListener = new LFURemovalListener();
    }

    @Override
    public void put(Integer key, Integer value) {
        long before = System.currentTimeMillis();
        synchronized (this) {
            Integer[] entry = cache.get(key);
            if (isNull(entry) && cache.size() >= maxSize) {
                cache.remove(getMinEntryKey());
            }
            cache.put(key, new Integer[]{value, 0});
        }
        long after = System.currentTimeMillis();
        totalLoadTime += after - before;
        totalCount++;
    }

    private Integer getMinEntryKey() {
        Integer minEntryKey = null;
        Integer minEntryValue = null;
        int minCount = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer[]> entry : cache.entrySet()) {
            int count = entry.getValue()[1];
            if (minCount >= count) {
                minCount = count;
                minEntryKey = entry.getKey();
                minEntryValue = entry.getValue()[0];
            }
        }
        cacheStatistic.setNumberEviction(cacheStatistic.getNumberEviction() + 1);
        lfuRemovalListener.writeToFile(minEntryKey, minEntryValue);
        return minEntryKey;
    }

    @Override
    public CacheStatistic getCacheStatistics() {
        cacheStatistic.setAverageWrite(totalLoadTime / totalCount);
        return cacheStatistic;
    }

    @Override
    public long getCacheSize() {
        return cache.size();
    }

    @Override
    public Integer get(Integer key) {
        Integer[] entries = cache.get(key);
        if (nonNull(entries)) {
            entries[1] += 1;
            return entries[0];
        }
        return null;
    }
}

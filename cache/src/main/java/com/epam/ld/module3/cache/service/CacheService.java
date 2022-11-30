package com.epam.ld.module3.cache.service;

import com.epam.ld.module3.cache.entity.CacheStatistic;

public interface CacheService {

    void put(Integer key, Integer value);

    Integer get(Integer key);

    CacheStatistic getCacheStatistics();

    long getCacheSize();
}

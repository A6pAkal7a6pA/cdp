package com.epam.ld.module3.cache.listener;

public interface RemovalListener {
    void writeToFile(Integer key, Integer value);
}

package com.epam.ld.module3.cache.listener.impl;

import com.epam.ld.module3.cache.file.FileWriter;
import com.epam.ld.module3.cache.listener.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class LRURemovalListener implements RemovalListener, com.google.common.cache.RemovalListener<Integer, Integer> {
    private static final String FILE_NAME = "lru_cache_logs.log";
    private final FileWriter fileWriter;

    public LRURemovalListener() {
        fileWriter = new FileWriter(FILE_NAME);
    }

    @Override
    public void onRemoval(RemovalNotification notification) {
        if (notification.wasEvicted()) {
            writeToFile(Integer.parseInt(notification.getKey().toString()), Integer.parseInt(notification.getValue().toString()));
        }
    }

    @Override
    public void writeToFile(Integer key, Integer value) {
        fileWriter.writeToLogFile(key, value);
    }
}

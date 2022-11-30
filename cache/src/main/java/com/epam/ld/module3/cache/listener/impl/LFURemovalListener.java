package com.epam.ld.module3.cache.listener.impl;

import com.epam.ld.module3.cache.file.FileWriter;
import com.epam.ld.module3.cache.listener.RemovalListener;

public class LFURemovalListener implements RemovalListener {
    private static final String FILE_NAME = "lfu_cache_logs.log";
    private final FileWriter fileWriter;

    public LFURemovalListener() {
        fileWriter = new FileWriter(FILE_NAME);
    }

    @Override
    public void writeToFile(Integer key, Integer value) {
        fileWriter.writeToLogFile(key, value);
    }
}

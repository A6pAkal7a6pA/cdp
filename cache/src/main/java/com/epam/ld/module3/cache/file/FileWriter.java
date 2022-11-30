package com.epam.ld.module3.cache.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static com.epam.ld.module3.cache.constant.CacheConstant.LOG_DATE_FORMAT;
import static com.epam.ld.module3.cache.constant.CacheConstant.LOG_FORMAT;

public class FileWriter {
    private Path filePath;
    private static final Logger LOGGER = Logger.getLogger(FileWriter.class.getName());

    /**
     * @param fileName the filename string
     */
    public FileWriter(String fileName) {
        try {
            filePath = Paths.get(fileName);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    /**
     * @param key   the entry key
     * @param value the entry value
     */
    public void writeToLogFile(Integer key, Integer value) {
        String log = String.format(LOG_FORMAT, new SimpleDateFormat(LOG_DATE_FORMAT).format(new Date()), key, value);
        try {
            Files.writeString(filePath, log, StandardOpenOption.APPEND);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

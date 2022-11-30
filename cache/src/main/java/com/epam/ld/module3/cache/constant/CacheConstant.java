package com.epam.ld.module3.cache.constant;

public final class CacheConstant {
    public static final int DEFAULT_MAX_SIZE = 100_000;
    public static final String LOG_FORMAT = "[%s] INFO : Removed entry -> key: %s, value: %s." + System.lineSeparator();
    public static final String LOG_DATE_FORMAT = "dd/MM/yyyy HH:mm";

    private CacheConstant() {}
}

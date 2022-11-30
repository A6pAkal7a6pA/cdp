package com.epam.ld.module3.cache.entity;

public class CacheStatistic {
    private long numberEviction;
    private double averageWrite;

    public CacheStatistic(long numberEviction, double averageWrite) {
        this.numberEviction = numberEviction;
        this.averageWrite = averageWrite;
    }

    public long getNumberEviction() {
        return numberEviction;
    }

    public void setNumberEviction(long numberEviction) {
        this.numberEviction = numberEviction;
    }

    public double getAverageWrite() {
        return averageWrite;
    }

    public void setAverageWrite(double averageWrite) {
        this.averageWrite = averageWrite;
    }

    @Override
    public String toString() {
        return "CacheStatistic{" +
                "numberEviction=" + numberEviction +
                ", averageWrite=" + averageWrite +
                '}';
    }
}

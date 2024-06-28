// Path: /src/main/java/com/example/Athlete.java
package com.example;

import java.util.Arrays;

public class Athlete implements Comparable<Athlete> {
    private int number;
    private String name;
    private String countryCode;
    private Time skiTime;
    private String[] shootingRanges;

    public Athlete(int number, String name, String countryCode, Time skiTime, String[] shootingRanges) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTime = skiTime;
        this.shootingRanges = shootingRanges;
    }

    public int calculateTotalTimeInSeconds() {
        int penaltySeconds = Arrays.stream(shootingRanges)
                                   .mapToInt(this::calculatePenalty)
                                   .sum();
        return skiTime.toSeconds() + penaltySeconds;
    }

    private int calculatePenalty(String shootingRange) {
        return (int) shootingRange.chars().filter(ch -> ch == 'o').count() * 10;
    }

    @Override
    public int compareTo(Athlete other) {
        return Integer.compare(this.calculateTotalTimeInSeconds(), other.calculateTotalTimeInSeconds());
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s + %d)", name, skiTime, skiTime, calculateTotalTimeInSeconds() - skiTime.toSeconds());
    }
}

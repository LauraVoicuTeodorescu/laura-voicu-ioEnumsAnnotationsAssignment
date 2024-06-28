// Path: /src/main/java/com/example/Time.java
package com.example;

public class Time {
    private int minutes;
    private int seconds;

    public Time(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int toSeconds() {
        return minutes * 60 + seconds;
    }

    public static Time parse(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return new Time(minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", minutes, seconds);
    }
}

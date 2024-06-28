// Path: /src/test/java/com/example/AthleteTest.java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AthleteTest {

    @Test
    public void testCalculateTotalTimeInSeconds() {
        Time skiTime = new Time(30, 27);
        Athlete athlete = new Athlete(11, "Umar Jorgson", "SK", skiTime, new String[]{"xxxox", "xxxxx", "xxoxo"});
        assertEquals(1857, athlete.calculateTotalTimeInSeconds());
    }
}

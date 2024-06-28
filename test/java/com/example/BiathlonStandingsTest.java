// Path: /src/test/java/com/example/BiathlonStandingsTest.java
package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BiathlonStandingsTest {

    @Test
    public void testParseCSV() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                         "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                         "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        BiathlonStandings standings = new BiathlonStandings();
        List<Athlete> athletes = standings.parseCSV(csvData);
        assertEquals(3, athletes.size());
    }

    @Test
    public void testCalculateStandings() {
        String csvData = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                         "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                         "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx";
        BiathlonStandings standings = new BiathlonStandings();
        List<Athlete> athletes = standings.parseCSV(csvData);
        List<Athlete> finalStandings = standings.calculateStandings(athletes);
        
        assertEquals("Piotr Smitzer", finalStandings.get(0).getName());
        assertEquals("Jimmy Smiles", finalStandings.get(1).getName());
        assertEquals("Umar Jorgson", finalStandings.get(2).getName());
    }
}

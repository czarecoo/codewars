package org.czareg.codewars.what.century.is.it;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CenturyFinderTest {

    @Test
    void testSpecific() {
        assertEquals("20th", CenturyFinder.whatCentury(1999));
        assertEquals("21st", CenturyFinder.whatCentury(2011));
        assertEquals("22nd", CenturyFinder.whatCentury(2154));
        assertEquals("23rd", CenturyFinder.whatCentury(2259));
        assertEquals("12th", CenturyFinder.whatCentury(1124));
        assertEquals("20th", CenturyFinder.whatCentury(2000));
    }

    @Test
    void testRandom() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int casual = rand.nextInt(9000) + 1000;
            assertEquals(solution(casual), CenturyFinder.whatCentury(casual));
        }
    }

    private static String solution(int year) {
        Map<Integer, String> post = new HashMap<>();
        post.put(0, "th");
        post.put(1, "st");
        post.put(2, "nd");
        post.put(3, "rd");
        int n = ((year + 99) / 100);
        if ((n % 10 >= 1) && (n % 10 <= 3) && ((n < 10) || (n > 20))) {
            return n + post.get(n % 10);
        }
        return n + post.get(0);
    }
}
package org.czareg.codewars.highest.and.lowest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighAndLowFinderTest {

    @Test
    void someTest() {
        assertEquals("542 -214", HighAndLowFinder.highAndLow("4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"));
    }

    @Test
    void sortTest() {
        assertEquals("10 -20", HighAndLowFinder.highAndLow("10 2 -1 -20"));
    }

    @Test
    void plusMinusTest() {
        assertEquals("1 -1", HighAndLowFinder.highAndLow("1 -1"));
    }

    @Test
    void plusPlusTest() {
        assertEquals("1 1", HighAndLowFinder.highAndLow("1 1"));
    }

    @Test
    void minusMinusTest() {
        assertEquals("-1 -1", HighAndLowFinder.highAndLow("-1 -1"));
    }

    @Test
    void plusMinusZeroTest() {
        assertEquals("1 -1", HighAndLowFinder.highAndLow("1 -1 0"));
    }

    @Test
    void plusPlusZeroTest() {
        assertEquals("1 0", HighAndLowFinder.highAndLow("1 1 0"));
    }

    @Test
    void minusMinusZeroTest() {
        assertEquals("0 -1", HighAndLowFinder.highAndLow("-1 -1 0"));
    }

    @Test
    void singleTest() {
        assertEquals("42 42", HighAndLowFinder.highAndLow("42"));
    }

    private static final int NUM_RANDOM_TESTS = 10;
    private static final int MAX_X = 1000;

    @Test
    void randomTest() {
        Random r = new Random();
        for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();

            for (int o = 0; o < r.nextInt(10) + 5; o++) {
                numbers.add(r.nextInt(MAX_X * 2) - MAX_X);
            }
            StringBuilder s = new StringBuilder(numbers.get(0).toString());
            for (int o = 1; o < numbers.size(); o++) {
                s.append(" ").append(numbers.get(o).toString());
            }
            assertEquals(Collections.max(numbers) + " " + Collections.min(numbers), HighAndLowFinder.highAndLow(s.toString()));
        }
    }
}
package org.czareg.codewars.clock;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MillisCounterTest {

    @Test
    void test1() {

        assertEquals(61000, MillisCounter.past(0, 1, 1));
    }

    @Test
    void randomTests() {
        Random r = new Random();
        for (int c = 0; c < 100; c++) {
            int i = r.nextInt(24);
            int j = r.nextInt(60);
            int s = r.nextInt(60);
            assertEquals(Sol(i, j, s), MillisCounter.past(i, j, s));
        }
    }

    public int Sol(int h, int m, int s) {
        return 1000 * (s + 60 * (m + 60 * h));
    }
}
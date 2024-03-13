package org.czareg.codewars.x.marks.the.spot;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExFactoryTest {

    @Test
    void basicTests() {
        assertEquals("X\n", ExFactory.markSpot(1));
        assertEquals("X   X\n  X\nX   X\n", ExFactory.markSpot(3));
        assertEquals("X       X\n  X   X\n    X\n  X   X\nX       X\n", ExFactory.markSpot(5));
        assertEquals("X                   X\n  X               X\n    X           X\n      X       X\n        X   X\n          X\n        X   X\n      X       X\n    X           X\n  X               X\nX                   X\n", ExFactory.markSpot(11));
        assertEquals("?", ExFactory.markSpot(-1));
        assertEquals("?", ExFactory.markSpot(2));
        assertEquals("?", ExFactory.markSpot(0.5f));
        assertEquals("?", ExFactory.markSpot(-3.5f));
    }

    @Test
    void randomTests() {
        Random random = new Random();
        for (int n = 1; n <= 50; n++) {
            float m = (float) (random.nextInt(82) - 10);
            if (random.nextBoolean())
                m /= random.nextInt(4) + 1;
            assertEquals(markSpotSolution(m), ExFactory.markSpot(m));
        }
    }

    private String markSpotSolution(float n) {
        if (n <= 0 || n % 1 != 0 || n % 2 == 0) return "?";
        int m = (int) n;
        StringBuilder spot = new StringBuilder();
        spot.append("  ".repeat(m / 2));
        spot.append("X\n");
        for (int i = m / 2 - 1; i >= 0; i--) {
            StringBuilder row = new StringBuilder();
            row.append("  ".repeat(i));
            row.append("X");
            row.append("    ".repeat(Math.max(0, m / 2 - i - 1)));
            row.append("   X\n");
            spot.insert(0, row).append(row);
        }
        return spot.toString();
    }
}
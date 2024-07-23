package org.czareg.codewars.highest.profit.wins;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MinMaxTest {

    Random rand = new Random();

    @Test
    void testExampleCases() {
        assertArrayEquals(new int[]{1, 5}, MinMax.minMax(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{5, 2334454}, MinMax.minMax(new int[]{2334454, 5}));
        assertArrayEquals(new int[]{1, 1}, MinMax.minMax(new int[]{1}));
    }

    @Test
    void minMaxRandomTest() {
        for (int i = 0; i < 20; i++) {
            int r = rand.nextInt();
            assertArrayEquals(new int[]{r, r}, MinMax.minMax(new int[]{r}));
        }
    }

    @Test
    void randomArrayTest() {
        int[] randl;
        for (int i = 0; i < 100; i++) {
            randl = new int[(Math.abs(rand.nextInt()) % 100) + 12];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = 0; j < randl.length; j++) {
                int t = rand.nextInt() % 99999 + 1;
                min = Math.min(t, min);
                max = Math.max(t, max);
                randl[j] = t;
            }
            assertArrayEquals(new int[]{min, max}, MinMax.minMax(randl));
        }
    }
}

package org.czareg.codewars.count.the.monkeys;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MonkeyCounterTest {

    @Test
    void basicTests() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, MonkeyCounter.monkeyCount(5));
        assertArrayEquals(new int[]{1, 2, 3}, MonkeyCounter.monkeyCount(3));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, MonkeyCounter.monkeyCount(9));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, MonkeyCounter.monkeyCount(10));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, MonkeyCounter.monkeyCount(20));
    }

    @Test
    void randomTests() {
        final Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            final int entero = 1 + rand.nextInt(100);
            assertArrayEquals(monkeyCount(entero), MonkeyCounter.monkeyCount(entero));
        }
    }

    private int[] monkeyCount(final int n) {
        int[] result = new int[n];
        Arrays.parallelSetAll(result, i -> i + 1);
        return result;
    }
}
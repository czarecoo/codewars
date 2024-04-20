package org.czareg.codewars.count.odd.numbers.below;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CounterTest {

    @Test
    void fixedTests() {
        assertEquals(7, Counter.oddCount(15));
        assertEquals(7511, Counter.oddCount(15023));
    }

    @Test
    void randomTest() {
        for (int i = 10; i < 1000; i++) {
            int x = rand((int) (2e9), 2147483647);
            assertEquals(x / 2, Counter.oddCount(x));
        }
    }

    public static int rand(int a, int b) {
        return (int) (Math.random() * ((b - a) + 1)) + a;
    }
}
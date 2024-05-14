package org.czareg.codewars.next.higher.with.same.bits;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SameBitsFinderTest {

    @Test
    void basicTests() {
        assertEquals(256, SameBitsFinder.nextHigher(128));
        assertEquals(2, SameBitsFinder.nextHigher(1));
        assertEquals(1279, SameBitsFinder.nextHigher(1022));
        assertEquals(191, SameBitsFinder.nextHigher(127));
        assertEquals(1253359, SameBitsFinder.nextHigher(1253343));
    }

    @Test
    void randomTests() {
        Random r = new Random();
        int m = (1 << 30) - 1;
        for (int i = 0; i < 100; i++) {
            int n = r.nextInt(m) + 1;
            assertEquals(solution(n), SameBitsFinder.nextHigher(n));
        }
    }

    private int solution(int n) {
        int o = n & -n;
        return n + o | ((n ^ n + o) / o >> 2);
    }
}
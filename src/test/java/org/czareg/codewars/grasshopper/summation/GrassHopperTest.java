package org.czareg.codewars.grasshopper.summation;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrassHopperTest {

    @Test
    void test1() {
        assertEquals(1, GrassHopper.summation(1));
    }

    @Test
    void test2() {
        assertEquals(36, GrassHopper.summation(8));
    }

    @Test
    void test3() {
        assertEquals(253, GrassHopper.summation(22));
    }

    @Test
    void test4() {
        assertEquals(5050, GrassHopper.summation(100));
    }

    @Test
    void test5() {
        assertEquals(22791, GrassHopper.summation(213));
    }

    @Test
    void test6() {
        Random rand = new Random();
        for (int i = 0; i < 50; ++i) {
            int n = rand.nextInt(100) + 1;
            assertEquals((int) (0.5 * n * (1 + n)), GrassHopper.summation(n));
        }
    }
}
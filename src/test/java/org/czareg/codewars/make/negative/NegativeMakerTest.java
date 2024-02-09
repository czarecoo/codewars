package org.czareg.codewars.make.negative;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NegativeMakerTest {

    private static final int NUM_RANDOM_TESTS = 10;
    private static final int MAX_X = 1000;

    private final Random random = new Random();

    @Test
    void test1() {
        assertEquals(-42, NegativeMaker.makeNegative(42));
    }

    @Test
    void test2() {
        assertEquals(-9, NegativeMaker.makeNegative(-9));
    }

    @Test
    void test3() {
        assertEquals(0, NegativeMaker.makeNegative(0));
    }

    @Test
    void test4() {
        assertEquals(-1, NegativeMaker.makeNegative(1));
    }

    @Test
    void test5() {
        assertEquals(-1, NegativeMaker.makeNegative(-1));
    }

    @Test
    void testRandomPositives() {
        for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
            int x = random.nextInt(MAX_X - 1) + 1;
            assertEquals(-abs(x), NegativeMaker.makeNegative(x));
        }
    }

    @Test
    void testRandomNegatives() {
        for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
            int x = -random.nextInt(MAX_X);
            assertEquals(-abs(x), NegativeMaker.makeNegative(x));
        }
    }
}
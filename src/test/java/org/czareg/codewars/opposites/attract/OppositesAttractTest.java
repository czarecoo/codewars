package org.czareg.codewars.opposites.attract;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class OppositesAttractTest {

    private static final int NUM_RANDOM_TESTS = 10;
    private static final int MAX_PETALS = 1000;

    @Test
    void testOddAndEven() {
        assertTrue(OppositesAttract.isLove(1, 4));
    }

    @Test
    void testEvenAndEven() {
        assertFalse(OppositesAttract.isLove(2, 2));
    }

    @Test
    void testOddAndOdd() {
        assertFalse(OppositesAttract.isLove(1, 1));
    }

    @Test
    void testEvenAndOdd() {
        assertTrue(OppositesAttract.isLove(0, 1));
    }

    @Test
    void testRandoms() {
        Random random = new Random();
        for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
            int flower1 = random.nextInt(MAX_PETALS);
            int flower2 = random.nextInt(MAX_PETALS);
            boolean expected = 1 == (flower1 + flower2) % 2;
            assertEquals(expected, OppositesAttract.isLove(flower1, flower2), String.format("Testing %d and %d petals", flower1, flower2));
        }
    }
}
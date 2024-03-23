package org.czareg.codewars.more.than.zero;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoreThanZeroTest {

    @Test
    void testSomething() {
        assertEquals("8 is more than zero.", MoreThanZero.corrections(8));
        assertEquals("1 is more than zero.", MoreThanZero.corrections(1));
        assertEquals("-2 is equal to or less than zero.", MoreThanZero.corrections(-2));
        assertEquals("-1 is equal to or less than zero.", MoreThanZero.corrections(-1));
        assertEquals("0 is equal to or less than zero.", MoreThanZero.corrections(0));
    }

    @Test
    void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(-100, 101);
            if (x > 0) {
                assertEquals(x + " is more than zero.", MoreThanZero.corrections(x));
            } else {
                assertEquals(x + " is equal to or less than zero.", MoreThanZero.corrections(x));
            }
        }
    }
}
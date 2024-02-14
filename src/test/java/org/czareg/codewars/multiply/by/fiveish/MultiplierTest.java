package org.czareg.codewars.multiply.by.fiveish;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplierTest {

    @Test
    void tests() {
        assertEquals(15, Multiplier.multiply(3), "For number = 3");
        assertEquals(250, Multiplier.multiply(10), "For number = 10");
        assertEquals(25000, Multiplier.multiply(200), "For number = 200");
        assertEquals(0, Multiplier.multiply(0), "For number = 0");
        assertEquals(-15, Multiplier.multiply(-3), "For number = -3");
        assertEquals(25, Multiplier.multiply(5), "For number = 5");
        assertEquals(-10, Multiplier.multiply(-2), "For number = -2");
        assertEquals(2_048_000_000, Multiplier.multiply(131072), "For number = 131072");
        assertEquals(-2_048_000_000, Multiplier.multiply(-131072), "For number = -131072");
    }

    @Test
    void randomTests() {
        var rnd = ThreadLocalRandom.current();
        for (int run = 0; run < 40; ++run) {
            int d = rnd.nextInt(4, 18); // expected for 131072 fits neatly into int
            int num = rnd.nextInt(-1 << d, (1 << d) + 1);
            int expected = num * (int) Math.pow(5, Integer.toString(Math.abs(num)).length());
            assertEquals(expected, Multiplier.multiply(num), "For number = " + num);
        }
    }
}
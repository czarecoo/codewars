package org.czareg.codewars.math.helper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntDoublerTest {

    @Test
    void test_one() {
        assertEquals(4, IntDoubler.doubleInteger(2));
    }

    @Test
    void test_two() {
        assertEquals(8, IntDoubler.doubleInteger(4));
    }

    @Test
    void test_three() {
        assertEquals(-20, IntDoubler.doubleInteger(-10));
    }

    @Test
    void test_four() {
        assertEquals(0, IntDoubler.doubleInteger(0));
    }

    @Test
    void test_five() {
        assertEquals(200, IntDoubler.doubleInteger(100));
    }

    private int randint(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int n = randint(-1000, 1000);
            int exp = n * 2;
            assertEquals(exp, IntDoubler.doubleInteger(n));
        }
    }
}
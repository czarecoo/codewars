package org.czareg.codewars.sum.of.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    @Test
    void testSample() {
        assertEquals(-1, Sum.getSum(0, -1));
        assertEquals(1, Sum.getSum(0, 1));
        assertEquals(2, Sum.getSum(-1, 2));
    }

    @Test
    void testPositive() {
        assertEquals(14, Sum.getSum(5, -1));
        assertEquals(127759, Sum.getSum(505, 4));
        assertEquals(44178, Sum.getSum(321, 123));
    }

    @Test
    void testNegative() {
        assertEquals(-1275, Sum.getSum(-50, 0));
        assertEquals(-15, Sum.getSum(-1, -5));
        assertEquals(-5, Sum.getSum(-5, -5));
        assertEquals(-127755, Sum.getSum(-505, 4));
        assertEquals(-44055, Sum.getSum(-321, 123));
    }

    @Test
    void testZero() {
        assertEquals(0, Sum.getSum(0, 0));
    }

    @Test
    void testSwitchMinMax() {
        assertEquals(-15, Sum.getSum(-5, -1));
        assertEquals(15, Sum.getSum(5, 1));
    }

    @Test
    void testEqual() {
        assertEquals(-17, Sum.getSum(-17, -17));
        assertEquals(17, Sum.getSum(17, 17));
    }
}
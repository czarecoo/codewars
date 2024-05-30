package org.czareg.codewars.overflowing.with.longing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplierTest {

    @Test
    void test00() {
        assertEquals(0, Multiplier.multiply(0, 0));
    }

    @Test
    void test2345() {
        assertEquals(1035, Multiplier.multiply(23, 45));
    }

    @Test
    void test3456() {
        assertEquals(-1904, Multiplier.multiply(-34, 56));
    }

    @Test
    void testMin() {
        assertEquals(Long.MIN_VALUE, Multiplier.multiply(-2147483648L, 4294967296L));
    }

    @Test
    void testMax() {
        assertEquals(Long.MAX_VALUE, Multiplier.multiply(2323823089L, 3969050863L));
    }

    @Test
    void testOverflowMax() {
        assertThrows(ArithmeticException.class, () -> Multiplier.multiply(Long.MAX_VALUE, Long.MAX_VALUE));
    }

    @Test
    void testOverflowMin() {
        assertThrows(ArithmeticException.class, () -> Multiplier.multiply(Long.MIN_VALUE, Long.MIN_VALUE));
    }

    @Test
    void testOverflowMaxMin() {
        assertThrows(ArithmeticException.class, () -> Multiplier.multiply(Long.MAX_VALUE, Long.MIN_VALUE));
    }

    @Test
    void testOverflow1() {
        assertThrows(ArithmeticException.class, () -> Multiplier.multiply(119537721L, 77158673929L));
    }

    @Test
    void testOverflow2() {
        assertThrows(ArithmeticException.class, () -> Multiplier.multiply(-2761311370L, 3340214413L));
    }
}
package org.czareg.codewars.swyply;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementTest {

    @Test
    void shouldThrowWhenWeightIsZero() {
        assertThrows(IllegalArgumentException.class, () -> new Element(0, 1));
    }

    @Test
    void shouldThrowWhenWeightIsThree() {
        assertThrows(IllegalArgumentException.class, () -> new Element(3, 1));
    }

    @Test
    void shouldThrowWhenValueIsNegativeOne() {
        assertThrows(IllegalArgumentException.class, () -> new Element(1, -1));
    }
}
package org.czareg.codewars.deodorant.evaporator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaporatorTest {

    @Test
    void testEvaporatorOne() {
        assertEquals(22, Evaporator.calculate(10, 10, 10));
    }

    @Test
    void testEvaporatorTwo() {
        assertEquals(29, Evaporator.calculate(10, 10, 5));
    }

    @Test
    void testEvaporatorThree() {
        assertEquals(59, Evaporator.calculate(100, 5, 5));
    }

    @Test
    void testEvaporatorFour() {
        assertEquals(37, Evaporator.calculate(50, 12, 1));
    }

    @Test
    void testEvaporatorFive() {
        assertEquals(31, Evaporator.calculate(47.5, 8, 8));
    }

    @Test
    void testEvaporatorSix() {
        assertEquals(459, Evaporator.calculate(100, 1, 1));
    }

    @Test
    void testEvaporatorSeven() {
        assertEquals(459, Evaporator.calculate(10, 1, 1));
    }

    @Test
    void testEvaporatorEight() {
        assertEquals(299, Evaporator.calculate(100, 1, 5));
    }
}
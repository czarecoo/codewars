package org.czareg.codewars.keep.hydrated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeepHydratedTest {

    @Test
    void test1() {
        assertEquals(1, KeepHydrated.liters(2));
    }

    @Test
    void test2() {
        assertEquals(0, KeepHydrated.liters(0.97));
    }

    @Test
    void test3() {
        assertEquals(7, KeepHydrated.liters(14.64));
    }

    @Test
    void test4() {
        assertEquals(800, KeepHydrated.liters(1600.20));
    }

    @Test
    void test5() {
        assertEquals(40, KeepHydrated.liters(80));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 5; i++) {
            double time = Math.random() * 100 + 1;
            assertEquals(((int) (time / 2)), KeepHydrated.liters(time));

            time = Math.random() * 10 + 1;
            assertEquals(((int) (time / 2)), KeepHydrated.liters(time));
        }
    }
}
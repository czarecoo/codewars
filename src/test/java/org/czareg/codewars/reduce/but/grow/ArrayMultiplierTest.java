package org.czareg.codewars.reduce.but.grow;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayMultiplierTest {

    @Test
    void testSomething() {
        assertEquals(6, ArrayMultiplier.grow(new int[]{1, 2, 3}));
        assertEquals(16, ArrayMultiplier.grow(new int[]{4, 1, 1, 1, 4}));
        assertEquals(64, ArrayMultiplier.grow(new int[]{2, 2, 2, 2, 2, 2}));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 100; i++) {
            int[] x = randomArray();
            assertEquals(grow(x), ArrayMultiplier.grow(x));
        }
    }

    public static int grow(int[] x) {
        int res = 1;
        for (int i : x)
            res *= i;
        return res;
    }

    public static int[] randomArray() {
        Random r = new Random();
        int size = r.nextInt(10) + 1;
        int[] res = new int[size];
        for (int i = 0; i < size; i++)
            res[i] = r.nextInt(10) + 1;
        return res;
    }
}
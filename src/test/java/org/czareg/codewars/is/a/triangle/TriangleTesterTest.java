package org.czareg.codewars.is.a.triangle;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTesterTest {

    @Test
    void basicTests() {
        doTest(true, 1, 2, 2);
        doTest(false, 7, 2, 2);
    }

    @Test
    void changingSidesTest() {
        doTest(false, 1, 2, 3);
        doTest(false, 1, 3, 2);
        doTest(false, 3, 1, 2);

        doTest(false, 1, 2, 5);
        doTest(false, 1, 5, 2);
        doTest(false, 5, 1, 2);
    }

    @Test
    void triangleTypes() {
        doTest(true, 4, 2, 3);
        doTest(true, 5, 1, 5);
        doTest(true, 2, 2, 2);
    }

    @Test
    void NegativeTypes() {
        doTest(false, -1, 2, 3);
        doTest(false, 1, -2, 3);
        doTest(false, 1, 2, -3);
        doTest(false, -5, 1, 3);
        doTest(false, 0, 2, 3);
    }

    @Test
    void RandomTests() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int a = rand.nextInt(-10, 100),
                    b = rand.nextInt(-10, 100),
                    c = rand.nextInt(-10, 100);
            boolean expected = (a + b > c) && (a + c > b) && (b + c > a);
            doTest(expected, a, b, c);
        }
    }

    private static void doTest(boolean expected, int a, int b, int c) {
        boolean actual = TriangleTester.isTriangle(a, b, c);
        String message = String.format("a = %d, b = %d, c = %d", a, b, c);
        assertEquals(expected, actual, message);
    }
}
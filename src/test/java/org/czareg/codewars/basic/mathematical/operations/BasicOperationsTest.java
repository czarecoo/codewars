package org.czareg.codewars.basic.mathematical.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicOperationsTest {

    @Test
    void testBasics() {
        assertEquals(11, BasicOperations.basicMath("+", 4, 7));
        assertEquals(-3, BasicOperations.basicMath("-", 15, 18));
        assertEquals(25, BasicOperations.basicMath("*", 5, 5));
        assertEquals(7, BasicOperations.basicMath("/", 49, 7));
    }

    @Test
    void testRandomAddition() {
        for (int i = 0; i < 5; i++) {
            double random1 = Math.floor(Math.random() * 1005);
            double random2 = Math.floor(Math.random() * 1005);
            int value1 = (int) random1;
            int value2 = (int) random2;
            assertEquals(value1 + value2, BasicOperations.basicMath("+", value1, value2));
        }
    }

    @Test
    void testRandomSubtraction() {
        for (int i = 0; i < 5; i++) {
            double random1 = Math.floor(Math.random() * 1005);
            double random2 = Math.floor(Math.random() * 1005);
            int value1 = (int) random1;
            int value2 = (int) random2;
            assertEquals(value1 - value2, BasicOperations.basicMath("-", value1, value2));
        }
    }

    @Test
    void testRandomMultiplication() {
        for (int i = 0; i < 5; i++) {
            double random1 = Math.floor(Math.random() * 1005);
            double random2 = Math.floor(Math.random() * 1005);
            int value1 = (int) random1;
            int value2 = (int) random2;
            assertEquals(value1 * value2, BasicOperations.basicMath("*", value1, value2));
        }
    }

    @Test
    void testRandomDivision() {
        for (int i = 0; i < 5; i++) {
            double random1 = Math.floor(Math.random() * 1005);
            double random2 = Math.floor(Math.random() * 1004) + 1;
            int value1 = (int) random1;
            int value2 = (int) random2;
            assertEquals(value1 / value2, BasicOperations.basicMath("/", value1, value2));
        }
    }
}

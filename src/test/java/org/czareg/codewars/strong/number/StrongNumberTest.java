package org.czareg.codewars.strong.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrongNumberTest {

    private static final String STRONG = "STRONG!!!!";
    private static final String NOT_STRONG = "Not Strong !!";

    private static int factorial(int num) {
        return (num == 0) ? 1 : num * factorial(num - 1);
    }

    private static String isStrongNumberSolution(int num) {
        String[] split = String.valueOf(num).split("");
        int sum = 0;
        for (String str : split) {
            sum += factorial(Integer.parseInt(str));
        }
        return (sum == num) ? "STRONG!!!!" : "Not Strong !!";
    }

    @Test
    void testSomething() {
        assertEquals(STRONG, StrongNumber.isStrongNumber(1));
        assertEquals(STRONG, StrongNumber.isStrongNumber(2));
        assertEquals(STRONG, StrongNumber.isStrongNumber(145));
        assertEquals(NOT_STRONG, StrongNumber.isStrongNumber(7));
        assertEquals(NOT_STRONG, StrongNumber.isStrongNumber(93));
        assertEquals(NOT_STRONG, StrongNumber.isStrongNumber(185));
    }

    @Test
    void randomTest() {
        for (int i = 0; i < 100; i++) {
            int randomNumber = 1 + (int) (Math.random() * 1000000);
            assertEquals(isStrongNumberSolution(randomNumber), StrongNumber.isStrongNumber(randomNumber));
        }
    }
}
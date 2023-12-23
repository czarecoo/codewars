package org.czareg.codewars.square.of.squares;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SquareCheckerTest {

    @Test
    void shouldWorkForSomeExamples() {
        assertFalse(SquareChecker.isSquare(-1), "negative numbers aren't SquareChecker numbers");
        assertTrue(SquareChecker.isSquare(0), "0 is a SquareChecker number (0 * 0)");
        assertFalse(SquareChecker.isSquare(3), "3 isn't a SquareChecker number");
        assertTrue(SquareChecker.isSquare(4), "4 is a SquareChecker number (2 * 2)");
        assertTrue(SquareChecker.isSquare(25), "25 is a SquareChecker number (5 * 5)");
        assertFalse(SquareChecker.isSquare(26), "26 isn't a SquareChecker number");
    }

    @Test
    void shouldWorkForRandomSquareNumbers() {
        Random rand = new Random();
        for (int i = 0; i < 100; ++i) {
            int randomNum = rand.nextInt(0x0fff);
            int randomSq = randomNum * randomNum;
            String message = String.format("%d is a square number (%d * %d)", randomSq, randomSq, randomSq);
            assertTrue(SquareChecker.isSquare(randomSq), message);
        }
    }

    @Test
    void shouldWorkForRandomNumbers() {
        Random rand = new Random();
        for (int i = 0; i < 100; ++i) {
            int randomNum = rand.nextInt(0x0fffffff);
            String message = String.format("Didn't work on %d", randomNum);
            assertEquals(isSquare(randomNum), SquareChecker.isSquare(randomNum), message);
        }
    }

    private static boolean isSquare(int n) {
        return n >= 0 && Math.pow(Math.round(Math.sqrt(n)), 2) == n;
    }
}
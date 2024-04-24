package org.czareg.codewars.square.every.digit;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareDigitTest {

    @Test
    void test() {
        assertEquals(811181, new SquareDigit().squareDigits(9119));
        assertEquals(0, new SquareDigit().squareDigits(0));
    }

    @Test
    void randomTest() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int test = 0;
            test += random.nextInt(10);
            test += random.nextInt(10) * 10;
            test += random.nextInt(10) * 10 * 10;
            test += random.nextInt(10) * 10 * 10 * 10;

            assertEquals(squareDigits(test), new SquareDigit().squareDigits(test));
        }
    }

    private int squareDigits(int n) {
        String strDigits = String.valueOf(n);
        StringBuilder result = new StringBuilder();

        for (char c : strDigits.toCharArray()) {
            int digit = Character.digit(c, 10);
            result.append(digit * digit);
        }

        return Integer.parseInt(result.toString());
    }
}
package org.czareg.codewars.check.digit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckDigitAdderTest {

    @Test
    void test() {
        testing("036532", "0365327");
        testing("12388878", "123888782");
        testing("111111111", "1111111118");
        testing("9735597355", "97355973550");
        testing("2356", "23566");
        testing("6789", "6789X");
    }

    @Test
    void test1() {
        for (int i = 0; i < 100; i++) {
            int n = randInt(1, 100);
            String input = generate(n);
            String expected = solution(input);
            testing(input, expected);
        }
    }

    private static void testing(String input, String expected) {
        assertEquals(expected, CheckDigitAdder.addCheckDigit(input));
    }

    public static String solution(String number) {
        int sum = 0;
        for (int i = number.length() - 1, multi = 2; i >= 0; i--) {
            char character = number.charAt(i);
            sum += Character.getNumericValue(character) * multi;
            if (++multi == 8) {
                multi = 2;
            }
        }
        String validator = String.valueOf(11 - (sum % 11));
        if (validator.equals("11")) {
            validator = "0";
        } else if (validator.equals("10")) {
            validator = "X";
        }
        return number + validator;
    }

    public static String generate(int digits) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            int digit = randInt(48, 57);
            result.appendCodePoint(digit);
        }
        return result.toString();
    }

    private static int randInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
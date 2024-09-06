package org.czareg.codewars.validate.pin.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void validPins() {
        assertTrue(Validator.validatePin("1234"));
        assertTrue(Validator.validatePin("0000"));
        assertTrue(Validator.validatePin("1111"));
        assertTrue(Validator.validatePin("123456"));
        assertTrue(Validator.validatePin("098765"));
        assertTrue(Validator.validatePin("000000"));
        assertTrue(Validator.validatePin("090909"));
    }

    @Test
    void nonDigitCharacters() {
        assertFalse(Validator.validatePin("a234"));
        assertFalse(Validator.validatePin(".234"));
    }

    @Test
    void invalidLengths() {
        assertFalse(Validator.validatePin("1"));
        assertFalse(Validator.validatePin("12"));
        assertFalse(Validator.validatePin("123"));
        assertFalse(Validator.validatePin("12345"));
        assertFalse(Validator.validatePin("1234567"));
        assertFalse(Validator.validatePin("-1234"));
        assertFalse(Validator.validatePin("-12345"));
        assertFalse(Validator.validatePin("1.234"));
        assertFalse(Validator.validatePin("00000000"));
    }

    @Test
    void edgeCases() {
        String[] edgeCaseStrings = {
                "",
                "123",
                "12345",
                "1234567",
                "1234567890",
                "1234x",
                "123456x",
                "12.0",
                "1234.0",
                "123456.0",
                "123\n",
                "1234\n",
                "09876\n",
                "098765\n",
                "-111",
                "111-",
                "-44444",
                "44444-",
                "+111",
                "+88888",
                "+1111",
                "-2018",
                "+234567",
                "-234567",
                "123/",
                "456:",
                "9¾9¾",
        };
        for (String s : edgeCaseStrings) {
            assertFalse(Validator.validatePin(s));
        }
    }

    @Test
    void randomTests() {
        BiFunction<Integer, Integer, Integer> randInt = (a, b) -> (int) (Math.floor(Math.random() * (b - a + 1)) + a);
        Supplier<List<String>> randValidPin = () -> {
            int length = Math.random() < 0.5 ? 4 : 6;
            String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            return IntStream.range(0, length).mapToObj(x -> digits[randInt.apply(0, digits.length - 1)]).collect(Collectors.toCollection(ArrayList::new));
        };

        for (int i = 0; i < 40; i++) {
            List<String> pin = randValidPin.get();
            if (Math.random() < 0.5)
                pin.set(randInt.apply(0, pin.size() - 1), Character.toString((char) (int) randInt.apply(32, 127)));

            assertEquals(solution(String.join("", pin)), Validator.validatePin(String.join("", pin)));
        }
    }

    private static boolean solution(String pin) {
        return pin.matches("^(\\d{4}|\\d{6})$");
    }
}
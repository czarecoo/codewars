package org.czareg.codewars.convert.str.to.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StrToArrayConverterTest {

    @Test
    void basicTests() {
        assertArrayEquals(new String[]{"Robin", "Singh"}, StrToArrayConverter.stringToArray("Robin Singh"));
        assertArrayEquals(new String[]{"I", "love", "arrays", "they", "are", "my", "favorite"}, StrToArrayConverter.stringToArray("I love arrays they are my favorite"));
    }

    @Test
    void randomTests() {
        for (int i = 0; i < 200; i++) {
            String testString = makeString(0, 30);
            assertArrayEquals(randomTest(testString), StrToArrayConverter.stringToArray(testString));
        }
    }

    private String makeString(int min, int max) {
        StringBuilder sb = new StringBuilder();
        int length = (int) Math.ceil((Math.random() * max) + min);

        for (int i = 0; i < length; i++) {
            sb.append(makeWord(min, max));
            if (i < length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private String makeWord(int min, int max) {
        StringBuilder sb = new StringBuilder();
        String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = (int) Math.ceil((Math.random() * max) + min);

        for (int i = 0; i < length; i++) {
            sb.append(possible.charAt((int) Math.floor(Math.random() * possible.length())));
        }

        return sb.toString();
    }

    private String[] randomTest(String s) {
        return s.split(" ");
    }
}
package org.czareg.codewars.reversed.strings;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversedStringsTest {

    // Reference implementation for random tests
    public static String _solution(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    @Test
    void sampleTests() {
        assertEquals("dlrow", ReversedStrings.solution("world"));
        assertEquals("olleh", ReversedStrings.solution("hello"));
        assertEquals("", ReversedStrings.solution(""));
        assertEquals("h", ReversedStrings.solution("h"));
        assertEquals("selur srawedoC", ReversedStrings.solution("Codewars rules"));
    }

    @Test
    void randomTests() {
        String chars = "abcdefghijklmnopqrstuvwxyz    ,./';123456789!?";
        Random random = new Random();

        for (int i = 0; i < 100; ++i) {
            String test = IntStream.range(1, random.nextInt(100))
                    .mapToObj(x -> Character.toString(chars.charAt(random.nextInt(chars.length()))))
                    .collect(Collectors.joining());

            String expected = _solution(test);
            String actual = ReversedStrings.solution(test);

            assertEquals(expected, actual);
        }
    }
}
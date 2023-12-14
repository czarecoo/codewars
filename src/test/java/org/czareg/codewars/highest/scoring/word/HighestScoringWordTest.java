package org.czareg.codewars.highest.scoring.word;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestScoringWordTest {

    // Reference implementation for random tests
    private static String _high(String s) {
        return Stream.of(s.split(" ")).max(Comparator.comparing((String a) -> a.chars().map(b -> b - 96).sum())).orElseThrow();
    }

    @Test
    void sampleTests() {
        assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
    }

    @Test
    void edgeCaseTests() {
        assertEquals("aa", HighestScoringWord.high("aa b"));
        assertEquals("b", HighestScoringWord.high("b aa"));
        assertEquals("bb", HighestScoringWord.high("bb d"));
        assertEquals("d", HighestScoringWord.high("d bb"));
        assertEquals("aaa", HighestScoringWord.high("aaa b"));
    }

    @Test
    void randomTests() {
        String chars = "      abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for (int i = 0; i < 100; ++i) {
            String test = IntStream.range(10, random.nextInt(201))
                    .mapToObj(x -> Character.toString(chars.charAt(random.nextInt(chars.length()))))
                    .collect(Collectors.joining()).trim().replaceAll("\\s+", " ");

            String expected = _high(test);
            String actual = HighestScoringWord.high(test);

            assertEquals(expected, actual);
        }
    }
}
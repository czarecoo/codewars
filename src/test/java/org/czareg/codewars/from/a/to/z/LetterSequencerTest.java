package org.czareg.codewars.from.a.to.z;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LetterSequencerTest {

    @DisplayName("Fixed Tests")
    @ParameterizedTest(name = "s = \"{0}\"")
    @CsvSource(textBlock = """
                b-i, bcdefghi
                q-y, qrstuvwxy
                e-f, ef
                G-G, G
                a-b, ab
                A-K, ABCDEFGHIJK
                a-q, abcdefghijklmnopq
                a-a, a
                g-i, ghi
                H-I, HI
                y-z, yz
                e-k, efghijk
                B-O, BCDEFGHIJKLMNO
                A-Z, ABCDEFGHIJKLMNOPQRSTUVWXYZ
                a-z, abcdefghijklmnopqrstuvwxyz
            """)
    @Order(1)
    void fixedTest(String s, String ans) {
        assertEquals(ans, LetterSequencer.gimmeTheLetters(s));
    }

    @DisplayName("Random Tests")
    @Order(2)
    @Test
    void randomTest() {
        var rand = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            boolean isCapital = rand.nextBoolean();
            int start = isCapital ? 'A' : 'a';
            int r = rand.nextInt(0, 26);
            start += r;
            int end = start + rand.nextInt(0, 26 - r);
            String input = "%s-%s".formatted((char) start, (char) end);
            assertEquals(solution(input), LetterSequencer.gimmeTheLetters(input));
        }
    }

    private String solution(String s) {
        StringBuilder b = new StringBuilder();
        for (int i = s.charAt(0); i <= s.charAt(2); i++) b.append((char) i);
        return b.toString();
    }
}
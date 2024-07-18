package org.czareg.codewars.split.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSplitTest {

    @Test
    void testEmptyString() {
        String s = "";
        assertEquals("[]", Arrays.toString(StringSplit.solution(s)));
    }

    @Test
    void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        assertEquals("[ab, cd, ef]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[He, ll, oW, or, ld]", Arrays.toString(StringSplit.solution(s1)));
    }

    @Test
    void testOddString() {
        String s = "abcde";
        String s1 = "LovePizza";
        assertEquals("[ab, cd, e_]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[Lo, ve, Pi, zz, a_]", Arrays.toString(StringSplit.solution(s1)));
    }

    @Test
    void testSpaceString() {
        String s = "Hello World";
        String s1 = "I Love Pizza";
        assertEquals("[He, ll, o , Wo, rl, d_]", Arrays.toString(StringSplit.solution(s)));
        assertEquals("[I , Lo, ve,  P, iz, za]", Arrays.toString(StringSplit.solution(s1)));
    }

    private final Random RANDOM = new Random();

    private char randomChar() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890    ";
        return alphabet.charAt(RANDOM.nextInt(alphabet.length()));
    }

    @Test
    void randomTests() {
        for (int trial = 1; trial <= 100; trial++) {
            String[] expected = new String[RANDOM.nextInt(21)];
            for (int i = 0; i < expected.length; i++) {
                expected[i] = "" + randomChar() + randomChar();
            }
            if (0 < expected.length && RANDOM.nextBoolean()) {
                expected[expected.length - 1] = randomChar() + "_";
            }
            StringBuilder sb = new StringBuilder();
            for (String s : expected) {
                sb.append(s);
            }
            assertEquals(Arrays.toString(expected), Arrays.toString(StringSplit.solution(sb.toString().replace("_$", ""))));
        }
    }
}